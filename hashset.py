class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for _ in range (self.buckets)]
        
    def bucket(self,key:int) -> int:
        return key % self.buckets
    
    def bucketItem(self,key:int)->int :
        return key // self.bucketItems
        

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if not (self.storage[bucket]):
            self.storage[bucket] = [None for _ in range(self.bucketItems+1)]
            
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        
        if not self.storage[bucket]:
            return 
        bucketItem = self.bucketItem(key)
        self.storage[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        
        if not self.storage[bucket]:
            return False
        
        bucketItem = self.bucketItem(key)
        
        return self.storage[bucket][bucketItem]
        
        """
        Returns true if this set contains the specified element
        """
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)