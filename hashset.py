class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.numBuckets = 1000
        self.sizeBucket = 1001
        self.Buckets = [None] * self.numBuckets

    def add(self, key: int) -> None:
        bucket = key % self.numBuckets                          #hashing function 1
        item = (key // self.numBuckets) % self.sizeBucket       #hashing function 2
        if not self.Buckets[bucket]:
            self.Buckets[bucket] = [False] * self.sizeBucket
        self.Buckets[bucket][item] = True
        return    

    def remove(self, key: int) -> None:
        bucket = key % self.numBuckets
        item = (key // self.numBuckets) % self.sizeBucket
        if not self.Buckets[bucket]:
            return
        else:
            self.Buckets[bucket][item] = False
            return
        
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = key % self.numBuckets
        item = (key // self.numBuckets) % self.sizeBucket
        if not self.Buckets[bucket]:
            return False
        else:
            return self.Buckets[bucket][item]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
