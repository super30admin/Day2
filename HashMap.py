# Time Complexity : O(1) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode: I ran this code in VS Code editor in my local machine
# Any problem you faced while coding this: No

class MyHashMap(object):

    def __init__(self):
        self.buckets = 10000
        self.bucketitems = 100 
        self.storage = [None]*self.buckets #Storage of array of Nodes

    class Node():

        def __init__(self,key,value):
            self.key = key
            self.value = value
            self.next = None

    def PrimaryHashFunction(self,key):
        return key % self.buckets

    #Function to find previous node of the current node
    def findPrevious(self, headNode, key):
        previousPointer = None
        self.curr = headNode

        #iterate until the end is reached and the key is found, to determine it's previous pointer
        while (self.curr != None and self.curr.key != key):
            previousPointer = self.curr
            self.curr = self.curr.next 
        return previousPointer

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primary_index = self.PrimaryHashFunction(key)
        
        #If primary storage is None, create a dummy node and point to that dummy node
        if self.storage[primary_index] == None:
            dummy = self.Node(-1,-1)
            self.storage[primary_index] = dummy
        #Find previous node of the given key but iterating from teh dummy node of given primary storage till the key is found
        previousNode = self.findPrevious(self.storage[primary_index], key)

        #If no same key is found, create new node and insert in the last 
        if previousNode.next == None:
            previousNode.next = self.Node(key,value)
        else: #if node with same key is found, overwrite the value
            previousNode.next.value = value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primary_index = self.PrimaryHashFunction(key)
        
        #If primary storage is None, nothing is stored in the Linked list, hence return -1
        if self.storage[primary_index] == None:
            return -1
        #If primary storage is not none, find previous of the given key starting from the primary storage index
        previousNode = self.findPrevious(self.storage[primary_index],key)
        
        #If previous node points to None, it means end of the LL is reached and key is not found. Hence return -1
        if previousNode.next == None:
            return -1
        #Return previous node's next node's value
        return previousNode.next.value


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = self.PrimaryHashFunction(key)

        #If primary storage is None, nothing is stored in the Linked list, so nothing to remove, hence return
        if self.storage[primary_index]==None:
            return
        #If primary storage is not none, find previous of the given key to be removed, starting from the primary storage index 
        previousNode = self.findPrevious(self.storage[primary_index],key)

        #If previous node points to None, it means end of the LL is reached and key is not found. Hence return -1
        if previousNode.next == None:
            return
        #If key is found, make previous pointer to point to current pointer's next, and make current ndoe as null
        curr = previousNode.next
        previousNode.next = curr.next

        curr = None 
        

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1001,1)
obj.put(2001,2)
param_1 = obj.get(2001)
print("Get value of key 2001:", param_1)
obj.remove(2001)
param_2 = obj.get(2001)
print("Get value of key 2001 after removal:", param_2)

# param_2 = obj.get(key)
# obj.remove(key)