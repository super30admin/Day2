'''
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.bucket
    
    def buckethash(self,key):
        return key%self.bucket
    
    def bucketItemhash(self,key):
        return key//self.bucketItems
    
    def add(self, key: int) -> None:
        bucket = self.buckethash(key)
        bucketItems = self.bucketItemhash(key)
        
        if(self.storage[bucket]==None):
            if(bucket==0):
                self.storage[bucket] = [None] * (self.bucketItems+1)
            else:
                self.storage[bucket] = [None] * self.bucketItems
        self.storage[bucket][bucketItems] = True
                     
    def remove(self, key: int) -> None:
        bucket = self.buckethash(key)
        bucketItems = self.bucketItemhash(key)
        if(self.storage[bucket]==None): return
        
        self.storage[bucket][bucketItems] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.buckethash(key)
        bucketItems = self.bucketItemhash(key)
        if(self.storage[bucket]==None): return
        return self.storage[bucket][bucketItems]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)