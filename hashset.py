# Time Complexity: O(1)
# Space Complexity: O(C) where C is the max number of elements that can be stored
# Ran on leetcode: Yes
# Difficulties: Working on double hashing

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket_size = 1000
        self.sub_bucket = 1001
        self.bucket = [[]] * self.bucket_size
    
    def hash_index(self, key):
        return key % self.bucket_size
        
    def sub_hash_index(self, key):
        return key // self.sub_bucket
    
    def add(self, key: int) -> None:
        hashed = self.hash_index(key)
        sub_hash = self.sub_hash_index(key)
        if not len(self.bucket[hashed]):
            self.bucket[hashed] = [False] * self.sub_bucket
        self.bucket[hashed][sub_hash] = True

    def remove(self, key: int) -> None:
        hashed = self.hash_index(key)
        sub_hash = self.sub_hash_index(key)
        if not len(self.bucket[hashed]):
            return
        self.bucket[hashed][sub_hash] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashed = self.hash_index(key)
        sub_hash = self.sub_hash_index(key)
        if not len(self.bucket[hashed]):
            return False
        return self.bucket[hashed][sub_hash]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)