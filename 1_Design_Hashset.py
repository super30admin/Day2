#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no
#Your code here along with comments explaining your approach:
#I have followed the concept we discussed during the class. by minimizing the space by taking the nearest square root of the data size as an array size.
class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage =[None]*self.buckets
        
    def bucket_fn(self, key):
        return key%self.buckets
    
    def bucketItem_fn(self, key):
        return key//self.bucketItems
    
    def add(self, key: int) -> None:
        bucket = self.bucket_fn(key)
        bucketItem = self.bucketItem_fn(key)
        if(self.storage[bucket] is None):
            if(bucket==0):
                self.storage[bucket]=[None]*(self.bucketItems+1)
            else:
                self.storage[bucket]=[None]*self.bucketItems
        self.storage[bucket][bucketItem]= True       

    def remove(self, key: int) -> None:
        bucket=self.bucket_fn(key)
        bucketItem=self.bucketItem_fn(key)
        if(self.storage[bucket]is None):
            return 
        self.storage[bucket][bucketItem]=False

    def contains(self, key: int) -> bool:
        bucket=self.bucket_fn(key)
        bucketItem=self.bucketItem_fn(key)
        if(self.storage[bucket]is None):
            return False
        return self.storage[bucket][bucketItem]