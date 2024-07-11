class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.storage = [None] * 10000

    def idx(self, key):
        return key % 10000

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        idx = self.idx(key)
        if self.storage[idx] is None:
            self.storage[idx] = Node(-1, -1)
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key):
        idx = self.idx(key)
        if self.storage[idx] is None:
            return -1
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key):
        idx = self.idx(key)
        if self.storage[idx] is None:
            return
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            return
        prev.next = prev.next.next
Time Complexity - O(1)
Space Complexity - O(n)