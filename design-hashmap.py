# Time Complexity:
# put, get, remove: Average O(1) for hash computation and bucket traversal; 
# worst-case O(n) when all keys hash to the same bucket (collision).
# Space Complexity:
# Overall: O(n + m), where n is the number of keys and m is the number of buckets (self.size). 
# Each bucket stores key-value pairs independently.
# Explanation:
# Hash Function: The hash(key) method determines the bucket index by taking the modulo of the key 
# with the fixed size, ensuring uniform distribution.
# Collision Handling: Each bucket is a list, and for operations (put, get, remove), 
# the bucket is traversed to find or update the key-value pair.
# Dynamic Storage: If the key doesn’t exist, it appends to the bucket; 
# if it does, the value is updated or the key is removed as needed.
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [[]] * self.size

    def hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        bucket_index = self.hash(key)
        for i, (k, v) in enumerate(self.buckets[bucket_index]):
            if k == key:
                self.buckets[bucket_index][i] = (key, value)
                return
        self.buckets[bucket_index].append((key, value))

    def get(self, key: int) -> int:
        bucket_index = self.hash(key)
        for k, v in self.buckets[bucket_index]:
            if k == key:
                return v

        return -1

    def remove(self, key: int) -> None:
        bucket_index = self.hash(key)
        for i, (k, v) in enumerate(self.buckets[bucket_index]):
            if k == key:
                del self.buckets[bucket_index][i]
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)