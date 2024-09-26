'''
Time Complexity : O(1) ...Average case
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
// Your code here along with comments explaining your approach'''

#Node creation
class Node:
    def __init__(self,key=None,value=None, next=None):
        self.key=key
        self.value=value
        self.next=None
        
class MyHashMap(object):

    def __init__(self):
        self.buckets=10000
        #Primary list creation
        self.table=[None]*self.buckets
        
    def hashingFunction(self,key):
        return key%self.buckets

    #Find if the key is present in the linked list or not.
    def find(self, head, key):
        prevPointer=None
        currPointer=head
        while currPointer is not None and currPointer.key != key:
            prevPointer=currPointer
            currPointer=currPointer.next
        return prevPointer
        
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primaryIndex= self.hashingFunction(key)
        #If LinkedList is not present then create a dummy node
        if self.table[primaryIndex] is None:
            self.table[primaryIndex]=Node(None,None)
        prevPointer=self.find(self.table[primaryIndex],key)
        #if key is already present, update the value
        if prevPointer.next is not None:
            prevPointer.next.value=value
        #else create a node
        else:
            prevPointer.next=Node(key,value)
            
            

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primaryIndex= self.hashingFunction(key)
        
        #If there is no entry at that index, that means that the key doesn't exist
        if self.table[primaryIndex] is None:
            return -1
        else:
            prevPointer=self.find(self.table[primaryIndex],key)
            if prevPointer.next is not None:
                return prevPointer.next.value
            else:
                #If the next node of the returned node is null then it means that the key doesn't exist
                return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryIndex= self.hashingFunction(key)
         #If there is no entry at that index, do nothing, else:
        if self.table[primaryIndex] is not None:
            prevPointer=self.find(self.table[primaryIndex],key)
            if prevPointer.next is not None:
                prevPointer.next=prevPointer.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
