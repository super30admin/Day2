// Time Complexity : 0(1)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Problem - 1 : Implement Queue using Stack
// T.C = O(1) for put,get,remmove

class MyQueue:

    def __init__(self):
        self.inStack = [] 
        self.outStack = []
        

    def push(self, x):
        self.inStack.append(x)
        

    def pop(self):
        self.peek()
        return self.outStack.pop()

        

    def peek(self):
        if(len(self.outStack) == 0 ):
            while(len(self.inStack) != 0):
                self.outStack.append(self.inStack.pop())
        
        return self.outStack[-1]
        

    def empty(self):
        return len(self.inStack) == 0 and len(self.outStack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

// Solution - 2 HashMap
//T.C = O(1) for push,pop,peek,empty

class Node():

    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
    
class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * (self.buckets)

    def getHashValue(self,key):
        return key % self.buckets
    
    def getPrev(self,head,key):
        prev = None
        curr = head

        while(curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

        

    def put(self, key, value):

        hashKey = self.getHashValue(key)

        if(self.storage[hashKey] is None):
            self.storage[hashKey] = Node(-1,-1)
        node = Node(key,value)
        prev = self.getPrev(self.storage[hashKey],key)

        if(prev.next is None):
            prev.next = node
        else:
            prev.next.value = value
        

    def get(self, key):
         hashKey = self.getHashValue(key)

         if(self.storage[hashKey] is None):
            return -1
         prev = self.getPrev(self.storage[hashKey],key)

         if(prev.next is None):
            return -1
         return prev.next.value
        

    def remove(self, key):
        hashKey = self.getHashValue(key)
        if(self.storage[hashKey] is None):
            return
        prev = self.getPrev(self.storage[hashKey],key)

        if(prev.next is None):
            return -1
        else:
            prev.next = prev.next.next

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
