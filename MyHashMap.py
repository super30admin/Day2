# Time Complexity : 
# - put: O(1) on average, O(n) in the worst case due to collision resolution
# - get: O(1) on average, O(n) in the worst case if the key is in a long chain
# - remove: O(1) on average, O(n) in the worst case for the same reason as get
#
# Space Complexity : O(n), where n is the number of key-value pairs stored in the hashmap.
#
# Did this code successfully run on Leetcode : Yes
#
# Any problem you faced while coding this : No significant issues; the chaining method for collision handling worked well.

class MyHashMap:

    def __init__(self):
        # Initialize the hash map with a fixed size (to reduce collisions)
        self.size = 1000  # Size of the hash table
        self.buckets = [[] for _ in range(self.size)]  # Create empty buckets

    def _hash(self, key: int) -> int:
        # Compute the hash for a given key
        return key % self.size

    def put(self, key: int, value: int) -> None:
        # Insert or update the key-value pair
        index = self._hash(key)
        # Search for the key in the corresponding bucket
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                # Key found; update the value
                self.buckets[index][i] = (key, value)
                return
        # Key not found; append new (key, value) pair
        self.buckets[index].append((key, value))

    def get(self, key: int) -> int:
        # Retrieve the value associated with the key
        index = self._hash(key)
        # Search for the key in the corresponding bucket
        for k, v in self.buckets[index]:
            if k == key:
                return v  # Return the associated value
        return -1  # Key not found

    def remove(self, key: int) -> None:
        # Remove the key-value pair if it exists
        index = self._hash(key)
        # Search for the key in the corresponding bucket
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                # Key found; remove the (key, value) pair
                del self.buckets[index][i]
                return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key, value)
# param_2 = obj.get(key)
# obj.remove(key)
