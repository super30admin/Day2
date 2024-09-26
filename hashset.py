class Bucket:
    
    def __init__(self):
        self.bucket = [False]*1001
        
    def add(self,key):
        print('add',key)
        self.bucket[key] = True
        
    def remove(self,key):
        self.bucket[key] = False
        
        



class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key = 1001
        self.buckets = [Bucket() for i in range(self.key)]
        
    def getBucket(self,key):
        return int(key % 1000)
    
    def getBucketItem(self,key):
        return int(key / 1000)
        
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)      
        self.buckets[bucket].add(bucketItem)
        
        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)      
        self.buckets[bucket].remove(bucketItem)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key) 
        return self.buckets[bucket].bucket[bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)