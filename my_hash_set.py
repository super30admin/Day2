class MyHashSet:
    def __init__(self):
        self.bucketSize = 1000
        self.itemListSize = 1000
        self.hashset = [None for _ in range(self.bucketSize+1)]
    
    """
        Get bucket number
        Takes O(1) time.
    """
    def getbucket(self, key):
        return key // self.bucketSize
    
    """
        Get element position
        Takes O(1) time.
    """
    def getItemPosition(self, key):
        return key % self.itemListSize

    """
        Adding new element to the hashset
        Takes O(1) time.
    """
    def add(self, key: int) -> None:
        bucket = self.getbucket(key)
        pos = self.getItemPosition(key)
        
        if self.hashset[bucket] == None:
            if bucket == 0:
                self.hashset[bucket] = [False for _ in range(self.itemListSize + 1)]
            else:
                self.hashset[bucket] = [False for _ in range(self.itemListSize + 1)]
        self.hashset[bucket][pos] = True

    """
        Removing the element to the hashset
        Takes O(1) time.
    """
    def remove(self, key: int) -> None:
        bucket = self.getbucket(key)
        pos = self.getItemPosition(key)
        if self.hashset[bucket] and self.hashset[bucket][pos]: 
            self.hashset[bucket][pos] = False
        else:
            return

    """
        Check if the element exist in the hashset
        Takes O(1) time.
    """
    def contains(self, key: int) -> bool:
        bucket = self.getbucket(key)
        pos = self.getItemPosition(key)
        if self.hashset[bucket] and self.hashset[bucket][pos]: 
            return True
        else: 
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)