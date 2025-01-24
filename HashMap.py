# Time Complexity : O(1) for put, get, and remove operations on average.
# Space Complexity : O(n) where n is the number of elements in the hashmap.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No significant issues faced.

# The MyHashMap class implements a simple linear hash map using separate chaining for collision resolution.
# It uses a linked list to handle collisions in each bucket. The put method adds a key-value pair,
# the get method retrieves a value by key, and the remove method deletes a key-value pair.

# Your code here along with comments explaining your approach
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.hashMap = [None]*self.buckets

    def hashIdx(self, key):
        return key%self.buckets

    def getPrev(self, head, key):
        prev, curr = None, head
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hashKey = self.hashIdx(key)
        if self.hashMap[hashKey] == None:
            self.hashMap[hashKey] = Node(-1,-1)
        prev = self.getPrev(self.hashMap[hashKey], key)
        if prev.next == None:
            prev.next = Node(key,value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        hashKey = self.hashIdx(key)
        if self.hashMap[hashKey] == None:
            return -1
        prev = self.getPrev(self.hashMap[hashKey], key)
        if prev.next:
            return prev.next.val
        return -1

    def remove(self, key: int) -> None:
        hashKey = self.hashIdx(key)
        if self.hashMap[hashKey] == None:
            return -1
        prev = self.getPrev(self.hashMap[hashKey], key)
        if prev.next:
            node = prev.next
            prev.next = node.next
            node.next = None

