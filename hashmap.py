# // Initialize a hashmap of size (10^6 +1) as None. Map key-valuie pair for put.
# // Time Complexity : O(1) for put get and remove 
# // Space Complexity : O(1) because no auxialliary space is required
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Tried using Linkedlists for collision. Could not solve in python. Here there is no hashing or collision detection involved.


# // Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        self.size = 1000001                                  # 10^6 +1 size 
        self.map = [None] * self.size                         

    def put(self, key: int, value: int) -> None:             # O(1)
        self.map[key] = value                                # key-value pair
        
    def get(self, key: int) -> int:                          # O(1)
        if self.map[key] == None:                            # if key is not present -1 else return value 
            return -1
        else:
            return self.map[key]
        

    def remove(self, key: int) -> None:                      # O(1) 
        self.map[key] = -1                                   # reset value to -1    


# class MyHashMap:
#     class Node:
       
#         def __init__(self, key: int, value: int) -> None:
#             self.key = key
#             self.value = value
#             self.next = None

#     def __init__(self):
#         self.buckets = 10000  
#         self.storage = [None] * self.buckets
    
#     def get_primary_hash(self, key: int) -> int:
#         return key % self.buckets

#     def get_previous(self, head: Node, key: int) -> Node:
#         prev = None
#         curr = head.next

#         while curr and curr.key != key:
#             prev = curr
#             curr = curr.next

#         return prev

#     def put(self, key: int, value: int) -> None:
#         primary_index = self.get_primary_hash(key)


#         if self.storage[primary_index] is None:                             
#             self.storage[primary_index] = self.Node(-1, -1)  # Dummy head

#         prev = self.get_previous(self.storage[primary_index], key)
#         curr = self.storage[primary_index].next

#         if curr:
#             # Key found, update the value
#             if curr.key == key:
#                 curr.value = value
#                 return
#         new_node = self.Node(key, value)
#         new_node.next = self.storage[primary_index].next
#         self.storage[primary_index].next = new_node

# # Example usage
# my_hash_map = MyHashMap()
# my_hash_map.put(1, 10)
# my_hash_map.put(2, 20)
# print(my_hash_map.get(1))  # Output: 10
# print(my_hash_map.get(3))  # Output: -1 (key not found)