from math import sqrt


class MyHashSet:

    def __init__(self, values=1000000):
        """
        Initialize your data structure here.
        """
        self.size = int(sqrt(values))
        self.buckets = [None] * self.size

    def _hash(self, key):
        return key % self.size, key // self.size

    def add(self, key: int) -> None:
        hash1, hash2 = self._hash(key)
        if not self.buckets[hash1]:
            self.buckets[hash1] = [False] * (self.size + 1)
        self.buckets[hash1][hash2] = True

    def remove(self, key: int) -> None:
        hash1, hash2 = self._hash(key)
        if self.buckets[hash1]:
            self.buckets[hash1][hash2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash1, hash2 = self._hash(key)
        if not self.buckets[hash1]:
            return False
        return self.buckets[hash1][hash2]

# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.next = None
#
# class LinkedList:
#     def __init__(self):
#         self.root = None
#         self.size = 0
#
#     def add(self, data: int) -> bool:
#         cur = self.root
#         node = Node(data)
#         if not cur:
#             self.root = node
#             self.size += 1
#             return True
#         while cur:
#             if cur.data == data:
#                 return False
#             elif cur.next is None:
#                 cur.next = node
#                 self.size += 1
#             cur = cur.next
#
#     def remove(self, data: int) -> bool:
#         cur = self.root
#         prev = None
#         while cur:
#             if cur.data == data:
#                 if cur == self.root:
#                     self.root = self.root.next
#                 else:
#                     prev.next = cur.next
#                 self.size -= 1
#                 return True
#             prev = cur
#             cur = cur.next
#         return False
#
#     def contains(self, data):
#         cur = self.root
#         while cur:
#             if cur.data == data:
#                 return True
#             cur = cur.next
#         return False
#
#
# class MyHashSet:
#     """
#     // Time Complexity :
#             O(1) to calculate the hash_key for any operation but later in average case
#             to access the element O(1) worst case will be O(n) will all always get hashed
#             to the same key.
#     // Space Complexity :
#             Costant size hash table but each node has a linked list which will be equal to the
#             number of nodes. O(n)
#     // Did this code successfully run on Leetcode :
#             Yes
#     // Any problem you faced while coding this :
#             I forget to write the return statement in one function and could not figure out
#             the problem. Spend 30 minutes to find that. I am such a dumb person :P
#
#     // Your code here along with comments explaining your approach
#             The idea is very similar to a hash map but the main difference is we are only storing
#             the key in hash set unlike both key and value in hash map. I am using the open addressing
#             chaining technique where each element in the hash table is a singly linked list.
#     """
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.max = 1000
#         self.hash_table = [None] * self.max
#         self.size = 0
#
#     def _hash(self, key):
#         return key % self.max
#
#     def add(self, key: int) -> None:
#         hash_key = self._hash(key)
#         if not self.hash_table[hash_key]:
#             self.hash_table[hash_key] = LinkedList()
#         if self.hash_table[hash_key].add(key):
#             self.size += 1
#
#     def remove(self, key: int) -> None:
#         hash_key = self._hash(key)
#         if self.hash_table[hash_key] and self.hash_table[hash_key].remove(key):
#             self.size -= 1
#
#     def contains(self, key: int) -> bool:
#         """
#         Returns true if this set contains the specified element
#         """
#         hash_key = self._hash(key)
#         if self.hash_table[hash_key]:
#             return self.hash_table[hash_key].contains(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# print(obj.add(1))
# print(obj.add(2))
# print(obj.contains(1))
# print(obj.contains(3))
# print(obj.add(2))
# print(obj.contains(2))
# print(obj.remove(2))
# print(obj.contains(2))
