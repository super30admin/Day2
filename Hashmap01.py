"""
1. Create a node before adding the node to map.
2. Calculate hash function of the key to add put new node or get value corresponding to key or remove node at given key

// Time Complexity : Average O(1) for push, get and remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Thinking in python. For example, if one should delete the node after removing, 
As typically in hasmap array is used, how can one use list similar to C (in past did DS in C).
"""
class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 500 # Initialize size
        self.table = [None] * self.size # Assign size to the hash table

    def _index(self, key:int)->int:
        return key % self.size # Hash function

    def put(self, key: int, value: int) -> None:
        idx = self._index(key) # Get index
        if not self.table[idx]:
            self.table[idx] = ListNode(key, value) # First create a node
            return
        current = self.table[idx]
        while current: # Search for a node which has key same as input key
            if current.key == key:
                current.value = value
                return
            if not current.next:
                current.next = ListNode(key, value)
                return
            current = current.next

    def get(self, key: int) -> int:
        idx = self._index(key)
        current = self.table[idx]

        while current:
            if current.key == key:
                return current.value
            current = current.next
        return -1    

    def remove(self, key: int) -> None:
        idx = self._index(key)
        current = self.table[idx]

        if not current:
            return
        if current.key == key:
            self.table[idx] = current.next
            return
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
                return
            current = current.next
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)