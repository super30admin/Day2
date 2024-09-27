class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.buckets = 10 ** 3
        self.bucketitems = 1001
        self.storage = [None] * self.buckets

    def bucket(self, key):
        return key % self.buckets

    def bucketitem(self, key):
        return key // self.bucketitems

    def add(self, key: int) -> None:
        bucket_key = self.bucket(key)
        bucketitem_key = self.bucketitem(key)
        if not self.storage[bucket_key]:
            self.storage[bucket_key] = [False] * self.bucketitems
        self.storage[bucket_key][bucketitem_key] = True

    def remove(self, key: int) -> None:
        bucket_key = self.bucket(key)
        bucketitem_key = self.bucketitem(key)
        if not self.storage[bucket_key]:
            return
        self.storage[bucket_key][bucketitem_key] = False
        return

    def contains(self, key: int) -> bool:
        bucket_key = self.bucket(key)
        bucketitem_key = self.bucketitem(key)
        if not self.storage[bucket_key]:
            return False
        return self.storage[bucket_key][bucketitem_key]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)