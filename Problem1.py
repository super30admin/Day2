class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.bucketitems = 1000

        self.storage = [[False] * 1001 for _ in range(1001)]

    def get_hash(self, key):
        return [key % self.bucket, key // self.bucket]

    def add(self, key: int) -> None:
        hashfn = self.get_hash(key)
        self.storage[hashfn[0]][hashfn[1]] = True

    def remove(self, key: int) -> None:
        hashfn = self.get_hash(key)
        self.storage[hashfn[0]][hashfn[1]] = False

    def contains(self, key: int) -> bool:
        hashfn = self.get_hash(key)
        return self.storage[hashfn[0]][hashfn[1]]
        """
        Returns true if this set contains the specified element
        """

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)