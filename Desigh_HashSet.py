class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arrSize = 1000
        self.bucketSize = 1001
        self.hashSet = [None for i in range(self.arrSize)]
        self.hash1 = lambda x : x % self.arrSize
        self.hash2 = lambda x : x % self.bucketSize

    def add(self, key: int) -> None:
        
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        
        if self.hashSet[hash1] is None:
            self.hashSet[hash1] = [False for i in range(self.bucketSize)]
        
        self.hashSet[hash1][hash2] = True
        

    def remove(self, key: int) -> None:
        
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        
        if self.hashSet[hash1] is None:
            
            return
        
        self.hashSet[hash1][hash2] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        
        if self.hashSet[hash1] is None or self.hashSet[hash1][hash2] is False:
            return False
        
        return True
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
