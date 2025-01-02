# Time Complexity: Best Case: O(1), Worst Case: O(n) where n is the number of elements in the linked list
# Space Complexity: O(n) where n is the number of elements in the linked list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# https://leetcode.com/problems/design-hashmap/description/

# Approach: 
# I used linked list simulation in each bucket of the hashmap.


class Node:
    def __init__(self, key=None, value=None, next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

        def __init__(self):
            self.size = 1000
            self.buckets = [None] * self.size
        
        def get_bucket_index(self, key):
            return key % self.size

        def put(self, key: int, value: int) -> None:
            index = self.get_bucket_index(key)
            if not self.buckets[index]:
                self.buckets[index] = Node(-1, -1)
            
            prev = self.find_node(index, key)
            if prev.next:
                prev.next.value = value
            else:
                prev.next = Node(key, value)

        def get(self, key):
            index = self.get_bucket_index(key)
        
            if not self.buckets[index]:
                return -1

            prev = self.find_node(index, key)
            return prev.next.value if prev.next else -1
        
        def remove(self, key: int) -> None:
            index = self.get_bucket_index(key)
        
            if not self.buckets[index]:
                return

            prev = self.find_node(index, key)
            if prev.next:
                prev.next = prev.next.next

        
        def find_node(self, index, key):
            prev  = self.buckets[index]
             
            while prev.next  and prev.next.key != key:
                prev = prev.next
            
            return prev

    

    # def __init__(self):
    #     self.size = 1000
    #     self.buckets = [[] for i in range(self.size)]
    
    # def get_bucket_index(self, key):
    #     return key % self.size

    # def put(self, key: int, value: int) -> None:
    #     index = self.get_bucket_index(key)

    #     for i , (k,v) in enumerate(self.buckets[index]):
    #         if k == key:
    #             self.buckets[index][i] = (key, value)
    #             return
    #     self.buckets[index].append((key, value))

    # def get(self, key: int) -> int:
    #     index = self.get_bucket_index(key)
    #     for k , v in self.buckets[index]:
    #         if k == key:
    #             return v
        
    #     return -1

    # def remove(self, key: int) -> None:
    #     index = self.get_bucket_index(key)
    #     for i , (k,v) in enumerate(self.buckets[index]):
    #         if k == key:
    #             del self.buckets[index][i]
    #             return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# class MyHashMap:

#     def __init__(self):
#         self.size = 1000
#         self.buckets = [[] for i in range(self.size)]
    
#     def get_bucket_index(self, key):
#         return key % self.size

#     def put(self, key: int, value: int) -> None:
#         index = self.get_bucket_index(key)

#         for i , (k,v) in enumerate(self.buckets[index]):
#             if k == key:
#                 self.buckets[index][i] = (key, value)
#                 return
#         self.buckets[index].append((key, value))

#     def get(self, key: int) -> int:
#         index = self.get_bucket_index(key)
#         for k , v in self.buckets[index]:
#             if k == key:
#                 return v
        
#         return -1

#     def remove(self, key: int) -> None:
#         index = self.get_bucket_index(key)
#         for i , (k,v) in enumerate(self.buckets[index]):
#             if k == key:
#                 del self.buckets[index][i]
#                 return
