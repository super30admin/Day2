class MyHashSet:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketsItems = 1001
        self.hashset = [['X' for y in range(self.bucketsItems)] for x in range(0, self.buckets)]
        
    def bucket(self, key: int) -> None:
        return key*self.buckets  
    
    def bucketItem(self, key: int) -> None:
        return key/self.bucketsItems 

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        print(bucket)
        bucketItem = self.bucketItem(key)
        if self.hashset[bucket] == 'X':
            self.hashset[bucket] = bucketItem
        self.hashset[bucket][bucketItem] = true

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.hashset[bucket] == 'X':
            return
        self.hashset[bucket][bucketItem] = true

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.hashset[bucket] == 'X':
            return false
        return self.hashset[bucket][bucketItem]

# could not finish this, lot of the method of Java are missing in python
# It would be great if you guys can discuss some python solutions.

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)