# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketItems = 1000
        self.storage = [False]*(self.bucket)
        
    def getBucket(self, key):
        return key % self.bucket
    
    def getBucketKey(self,key):
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketKey(key)
        
        if self.storage[bucket] is False:
            if bucket == 0:
                self.storage[bucket] = [False]*(self.bucketItems+1)
            else:
                self.storage[bucket] = [False]*self.bucketItems
    

        self.storage[bucket][bucketItem] = True
            
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketKey(key)
        
        if self.storage[bucket] is False:
            return
        
        self.storage[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketKey(key)
        
        if self.storage[bucket] is False:
            return self.storage[bucket]
        
        return self.storage[bucket][bucketItem]  