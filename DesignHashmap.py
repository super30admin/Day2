# Time Complexity: O(n/k) for put(), get(), and remove(), where n is the number of elements and k is the bucket count.
# Space Complexity: O(n + k), where n is the number of elements and k is the number of buckets (10000 here).
# Approach: Used separate chaining with linked lists to handle collisions. Each bucket stores key-value pairs as nodes.

class MyHashMap:

    class Node:
        def __init__(self, key, value, next=None):
            self.key = key
            self.value = value
            self.next = next

    def __init__(self):
        self.arr = [None] * 10000  # Array to store the hash buckets

    def hash_func(self, key):
        return key % 10000  # Simple modulo-based hash function

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] is None:
            self.arr[idx] = self.Node(-1, -1)  # Dummy node for easier operations
        prev = self.find(self.arr[idx], key)
        if prev.next is None:
            prev.next = self.Node(key, value)  # Add new node
        else:
            prev.next.value = value  # Update existing node's value

    def get(self, key: int) -> int:
        idx = self.hash_func(key)
        if self.arr[idx] is None:
            return -1
        prev = self.find(self.arr[idx], key)
        if prev.next is None:
            return -1  # Key does not exist
        return prev.next.value  # Return the value

    def remove(self, key: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] is None:
            return
        prev = self.find(self.arr[idx], key)
        if prev.next is None:
            return  # Key does not exist
        prev.next = prev.next.next  # Remove the node
