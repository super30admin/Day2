# Time Complexity :
#   add:    O(1)
#   pop:    O(1)
#   top:    O(1)
#   empty:  O(1)
# 
# Space Complexity : O(n)[n is the number of elements saved]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
# 
# 1. Double hashing(Mod and Division operator) has been used to avoid collisions
# 
# 
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000 # The n range is 1 - 1000000. So we take the square root of upper bound as the size of the list
        self.bucketItems = 1001
        self.storage = [None for i in range(self.buckets)]
        
    def __getBucket(self, key):
        """
        Utitlity method to get the bucket index from key
        """
        return key % self.buckets
    
    def __getBucketItem(self, key):
        """
        Utitlity method to get the bucket Item index from key
        """
        return key // self.buckets
        

    def add(self, key: int) -> None:
        bucket = self.__getBucket(key)
        bucketItem = self.__getBucketItem(key)
        
        if not self.storage[bucket]: # True, when there is no element present at this bucket index
            self.storage[bucket] = [False for i in range(self.bucketItems)]
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.__getBucket(key)
        bucketItem = self.__getBucketItem(key)
        if self.storage[bucket]:
            self.storage[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.__getBucket(key)
        bucketItem = self.__getBucketItem(key)
        if self.storage[bucket]: # True only if bucket items list is present
            return self.storage[bucket][bucketItem]
        return False # Return false if there is no bucket item list


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)