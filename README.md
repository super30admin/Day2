# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
#All operations O(1) time complexity
class MyQueue:
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x):
        self.s1.append(x)

    def pop(self):
        self.peek()
        return self.s2.pop()

    def peek(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]        

    def empty(self):
        return not self.s1 and not self.s2


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashSet:

    def __init__(self):
        self.keysize=10000
        self.hash1=[Bucket() for _ in range(self.keysize)]
    def hf(self, key):
        return key % 10000

    def add(self, key: int) -> None:
        self.hash1[self.hf(key)].insert(key)
    def remove(self, key: int) -> None:
        self.hash1[self.hf(key)].remove(key)

    def contains(self, key: int) -> bool:
        return self.hash1[self.hf(key)].exists(key)
class Node:
    def __init__(self,data):
        self.data=data
        self.next=None
class Bucket:
    def __init__(self):
        self.head=Node(0)
    def insert(self,key):
        if not self.exists(key):
            n=Node(key)
            n.next=self.head.next
            self.head.next=n
    def remove(self,key):
        p=self.head
        c=self.head.next
        if self.exists(key):
            while c!=None:
                if c.data==key:
                    p.next=c.next
                    return
                p=c
                c=c.next
    def exists(self,key):
        p=self.head.next
        while p!=None:
            if p.data==key:
                return True
            p=p.next
        return False


