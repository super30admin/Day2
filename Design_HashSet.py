# Time Complexity : O(n/2069) = O(n)
# Space Complexity : same as hashmap - O(k+m) k=2069 buckets and m is number of unique values which would not require bucket.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here, we will implement Lineae chaining to handle collisions
# As per yesterday's(12/21) discussion, we can implement bucket using LinkedList, array or BST. Here, I will be using LinkedList.

# Linked List implementation same as Design-1 with changes: 
# 1. "exists" function instead of find function
# 2. Modification to append function of Linked-list(Bucket) : if element is repeatation, do not chain it!
class ListNode:
    def __init__(self, data=None, nextNode=None):
        self.data = data
        self.next = nextNode

class Bucket:
    def __init__(self):
        self.head = ListNode(0)
        
    def append(self, data):
        # if this value exists, we skip
        if not self.exists(data):
            newNode = ListNode(data, self.head.next)
            self.head.next = newNode

    def remove(self, key):
        sentinel = ListNode(0)
        sentinel.next = self.head
        prev, temp = sentinel, self.head
        found = False
        while temp and not found:
            if temp.data == key:
                prev.next = temp.next 
                found = True
            else:
                prev = temp
                temp = temp.next
        return sentinel.next
    
    def exists(self, value):
        curr = self.head.next
        while curr is not None:
            if curr.data == value:
                return True
            curr = curr.next
        return False
    
class MyHashSet:
    def __init__(self):
        # chose a prime number as modulo
        self.modulo = 2069
        # build modulo number of buckets
        self.bucket = [Bucket() for i in range(self.modulo)]
    
    def generateHashKey(self, key):
        return key % self.modulo

    def add(self, key):
        index = self.generateHashKey(key)
        self.bucket[index].append(key) 

    def remove(self, key):
        index = self.generateHashKey(key)
        self.bucket[index].remove(key)
    
    def contains(self, key):
        index = self.generateHashKey(key)
        return self.bucket[index].exists(key)
    

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.add(3)
obj.remove(2)

check1 = obj.contains(2)
check2 = obj.contains(3)

print(check1, check2)