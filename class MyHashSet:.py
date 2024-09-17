class MyHashSet:
    
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage =  [None] * self.buckets
        
    def getBucket(self, key):
        return key % self.buckets
    
    def getBucketItem(self, key):
        return key // self.bucketItems
    
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if not self.storage[bucket]:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if not self.storage[bucket]:
            return False
        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)