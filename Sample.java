// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Problem 1: Implement a Queue using Stacks
class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
        
    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
            return self.outStack.pop()
        else:
            return self.outStack.pop()

        
    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0
       
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

// # Problem 2: Design Hashmap
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets
        
    def getHash(self, key):
        return key % self.buckets
    
    def getPrev(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:   
            # use '!=', and not 'is not' as 'is' checks for object identity and not equality
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hash_val = self.getHash(key)
        if self.storage[hash_val] is None:
            self.storage[hash_val] = Node(-1, -1)
        prev = self.getPrev(self.storage[hash_val], key)
        if prev.next == None:
            prev.next = Node(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        hash_value = self.getHash(key)
        if self.storage[hash_value] == None:
            return -1
        else:
            prev = self.getPrev(self.storage[hash_value], key)
            if prev.next is None:
                return -1
            else:
                return prev.next.value
        

    def remove(self, key: int) -> None:
        hash_value = self.getHash(key)
        if self.storage[hash_value] == None:
            return 
        else:
            prev = self.getPrev(self.storage[hash_value], key)
            if prev.next is None:
                return -1
            else:
                curr = prev.next
                prev.next = curr.next
                curr.next = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

