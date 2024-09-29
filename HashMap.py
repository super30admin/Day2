# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the concept of chaining


# Your code here along with comments explaining your approach
class MyHashMap:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None
    #Initialise the storage
    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets
    #Hash Function
    def get_hash(self, key):
        return key % self.buckets

    def get_prev(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev
    #To insert a value into hashmap
    def put(self, key, value):
        hash_index = self.get_hash(key)
        if self.storage[hash_index] is None:
            self.storage[hash_index] = self.Node(-1, -1)  # Dummy node
        prev = self.get_prev(self.storage[hash_index], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value
    #To search a value in hashmap
    def get(self, key):
        hash_index = self.get_hash(key)
        if self.storage[hash_index] is None:
            return -1
        prev = self.get_prev(self.storage[hash_index], key)
        if prev.next is None:  # Node doesn't exist
            return -1
        else:
            return prev.next.value  # Existing node
    #To delete a value from hashmap
    def remove(self, key):
        hash_index = self.get_hash(key)
        if self.storage[hash_index] is None:
            return
        prev = self.get_prev(self.storage[hash_index], key)
        if prev.next is None:  # Node doesn't exist
            return
        curr = prev.next
        prev.next = prev.next.next
