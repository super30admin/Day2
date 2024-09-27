class MyHashSet:

    def __init__(self):
        self.storage = [None] * 1000
        self.buckets = 1000
        self.bucketItems = 1000
        
    def bucket(self, key: int) -> int:
        return key % self.buckets
    
    def bucketItem(self, key: int) -> int:
        return key // self.bucketItems
    
    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True
        
    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if not self.storage[bucket]:
            return
        self.storage[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if not self.storage[bucket]:
            return False
        return self.storage[bucket][bucketItem]
        

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))