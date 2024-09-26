# Time complexity - O(1)
# Space complexity - O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        self.hashmap = {}
    
    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value
        

    def get(self, key: int) -> int:
        if key in self.hashmap:
            return self.hashmap[key]
        else:
            return -1
        

    def remove(self, key: int) -> None:
        if key in self.hashmap:
            self.hashmap.pop(key)
        else:
            return -1
        

# Using Linear Chaining

# class Node:
#     def __init__(self, key, value):
#         self.key = key
#         self.value = value
#         self.next = None

# class MyHashMap:
#     def __init__(self):
#         self.size = 10000
#         self.hashmap = [None] * self.size

#     def hash(self, key):
#         return key % self.size

#     def put(self, key, value):
#         x = self.hash(key)
#         temp = self.hashmap[x]
#         if not temp:
#             self.hashmap[x] = Node(key, value)
#         else:
#             while temp:
#                 if temp.key == key:
#                     temp.value = value
#                     return
#                 prev = temp
#                 temp = temp.next
#             prev.next = Node(key, value)

#     def get(self, key):
#         x = self.hash(key)
#         temp = self.hashmap[x]
#         while temp:
#             if temp.key == key:
#                 return temp.value
#             temp = temp.next
#         return -1

#     def remove(self, key):
#         x = self.hash(key)
#         temp = self.hashmap[x]
#         if temp and temp.key == key:
#             self.hashmap[x] = temp.next
#             return
#         while temp:
#             if temp.key == key:
#                 prev.next = temp.next
#                 return
#             prev = temp
#             temp = temp.next
