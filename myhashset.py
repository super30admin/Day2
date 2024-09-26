# Time Complexity : O(1)
# Space Complexity : O(N + K) for N buckets and K keys inserted into the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, it took me a few tries to write the 
# initialisation of the 2d array as a hashmap in Python correctly



class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.myhashset = [None] * self.buckets
    
    def bucket(self, key) -> int:
        return key % self.buckets
    
    def bucketItem(self, key) -> int:
        return key // self.bucketItems
    
    def add(self, key) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.myhashset[bucket] is None:
            if bucket == 0:
                self.myhashset[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.myhashset[bucket] = [False] * (self.bucketItems)
        self.myhashset[bucket][bucketItem] = True
    
    def remove(self, key) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.myhashset[bucket] is None:
            return
        self.myhashset[bucket][bucketItem] = False
    
    def contains(self, key) -> bool:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.myhashset[bucket] is None:
            return False
        return self.myhashset[bucket][bucketItem]


h1 = MyHashSet()
h1.add(51)
h1.add(61)
h1.remove(61)
print(h1.contains(51))