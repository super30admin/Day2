'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:
To implement hashset, we will be using linked list. This will help us remove 
and insert elements in O(1) time. 
'''

class Node(object):
    def __init__(self,key,next):
        self.key = key
        self.next = next

class MyHashSet(object):

    def __init__(self):
        self.size = 10000
        self.buckets = [None]*self.size
    
    def generateHash(self,key):
        return  key % self.size

    def add(self, key):
        hashValue = self.generateHash(key)
        current = self.buckets[hashValue]
        if not current: 
            self.buckets[hashValue] = Node(key, None)
            return
        if current.key == key:
            return 
        while current:
            if current.key == key: 
                return
            if not current.next: 
                current.next = Node(key,None)
                return 
            if current.next: 
                current = current.next
        return 

    def remove(self, key):
        hashValue = self.generateHash(key)
        current = self.buckets[hashValue]
        if not current:
            return 
        if current.key == key:
            self.buckets[hashValue] = current.next
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
                return 
            current = current.next
        return
        

    def contains(self, key):
        hashValue = self.generateHash(key)
        current = self.buckets[hashValue]
        while current:
            if current.key == key:
                return True
            current = current.next
        return False