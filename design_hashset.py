class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.data = [None] * self.buckets
        

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if not self.data[bucket]:
            self.data[bucket] = [None] * self.bucketItems
        self.data[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.data[bucket]:
            self.data[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        return self.data[bucket] and self.data[bucket][bucketItem]
        
        
    def bucket(self, key):
        return key % self.buckets
    
    def bucketItem(self, key):
        return key // self.buckets
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
