// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//706. Design HashMap
//T.C = O(1) for put,get,remmove
class Node():

    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap(object):

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * (self.buckets)
    
    def getHashValue(self,key):
        return key % self.buckets
    def getPrevValue(self,head,key):
        prev = None
        curr = head

        while(curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev


    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """

        hashIdx = self.getHashValue(key)

        if(self.storage[hashIdx] is None):
            self.storage[hashIdx] = Node(-1,-1)
        node = Node(key,value)
        prev = self.getPrevValue(self.storage[hashIdx],key)

        if(prev.next is None):
            prev.next = node
        else:
            prev.next.value = value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hashIdx = self.getHashValue(key)
        if(self.storage[hashIdx] is None):
            return -1
        prev = self.getPrevValue(self.storage[hashIdx],key)

        if(prev.next is None):
            return -1
        return prev.next.value
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """

        hashIdx = self.getHashValue(key)

        if(self.storage[hashIdx] is None):
            return
        
        prev = self.getPrevValue(self.storage[hashIdx],key)

        if(prev.next is None):
            return -1
        else:
            prev.next = prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


//232. Implement Queue using Stacks
//T.C = O(1) for push,pop,peek,empty
class MyQueue(object):

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.inStack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if(len(self.outStack) == 0):
            while(len(self.inStack) !=0):
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self):
        """
        :rtype: int
        """
        if(len(self.outStack) == 0):
            while(len(self.inStack) !=0):
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]      

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.inStack) == 0 and len(self.outStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()