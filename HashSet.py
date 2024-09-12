class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        # self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def gethashvalue(self, key):
        return key % self.buckets

    def add(self, key: int) -> None:
        bucket = self.gethashvalue(key)
        # bucketItem = key%self.bucketItems
        if self.storage[bucket] == None:
            self.storage[bucket] = [key]
        else:
            self.storage[bucket].append(key)

    def remove(self, key: int) -> None:
        bucket = self.gethashvalue(key)
        if self.storage[bucket] != None:
            while key in self.storage[bucket]:
                self.storage[bucket].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.gethashvalue(key)
        if self.storage[bucket] != None:
            if key in self.storage[bucket]:
                return True
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)