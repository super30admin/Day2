class MyHashMap(object):

    def __init__(self):
        self.buckets = 10000
        self.bucketitems = 100 
        self.storage = [None]*self.buckets

    class Node():

        def __init__(self,key,value):
            self.key = key
            self.value = value
            self.next = None

    def PrimaryHashFunction(self,key):
        return key % self.buckets

    def findPrevious(self, headNode, key):
        previousPointer = None
        self.curr = headNode

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
        
        if self.storage[primary_index] == None:
            dummy = self.Node(-1,-1)
            self.storage[primary_index] = dummy
        previousNode = self.findPrevious(self.storage[primary_index], key)

        if previousNode.next == None:
            previousNode.next = self.Node(key,value)
        else:
            previousNode.next.value = value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primary_index = self.PrimaryHashFunction(key)
        
        if self.storage[primary_index] == None:
            return -1
        
        previousNode = self.findPrevious(self.storage[primary_index],key)
        
        if previousNode.next == None:
            return -1
        
        return previousNode.next.value


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = self.PrimaryHashFunction(key)

        if self.storage[primary_index]==None:
            return
        previousNode = self.findPrevious(self.storage[primary_index],key)

        if previousNode.next == None:
            return
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