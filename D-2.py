## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack)>0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0

# TC=> Push : O(1), pop(1), peek(1) , empty(1)

## Problem 2:Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap:

    class Node:
        def __init__(self,key:int, value:int):
            self.key = key
            self.value = value
            self.next = None

    def find(self, node: Node, key: int)-> Node:
        prev = node
        curr = prev.next
        while curr!= None and curr.key!=key:
            prev = curr
            curr = curr.next
        return prev

    def getBucket(self, key:int)-> int:
        return key % self.buckets        

    def __init__(self):
        self.buckets = 1000
        self.storage = [None]*self.buckets

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1,-1)
        prev = self.find(self.storage[bucket],key)
        if prev.next == None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value
        
    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(self.storage[bucket],key)
        if prev.next == None:
            return -1
        return prev.next.value
        
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return
        prev = self.find(self.storage[bucket], key)
        if prev.next == None:
            return
        prev.next = prev.next.next
        
# TC=> put =O(n), get =O(n), remove =O(n)