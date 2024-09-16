class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset=[None]*1000
        self.buckets = 1000
        self.bucketItems=1000
        
    def bucket(self, key:int) -> int:
        return key%self.buckets
    
    def bucketItem(self, key:int) -> int:
        return key//self.bucketItems
            
        
        
        

    def add(self, key: int) -> None:
        bucket=self.bucket(key)
        bucketItem=self.bucketItem(key)
        if self.hashset[bucket]==None:
            self.hashset[bucket]=[None]*self.bucketItems
        self.hashset[bucket][bucketItem]=True    
            
        
        
        

    def remove(self, key: int) -> None:
        bucket=self.bucket(key)
        bucketItem=self.bucketItem(key)
        if self.hashset[bucket]==None:
            return
            
        self.hashset[bucket][bucketItem]=False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket=self.bucket(key)
        bucketItem=self.bucketItem(key)
        return self.hashset[bucket]!=None and self.hashset[bucket][bucketItem]
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
