class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        Solving using Double Hashing
        1st Hashing: - val%1000
        2nd Hashing: - val//1000

        Create a list of lists , each inner list is a bucket
        1st hashing will pick which bucket will store the element, 2nd hashing will decide which slot in the bucket will store the element
        """
        self.buckets = 1000
        self.bucketItems = 1001
        self.storage = [[False for i in range(self.bucketItems)] for i in range(self.buckets)]

    def bucket_hashing(self, key):
        return key % self.buckets

    def bucket_item_hashing(self, key):
        return key % self.bucketItems

    def add(self, key: int) -> None:
        self.storage[self.bucket_hashing(key)][self.bucket_item_hashing(key)] = True

    def remove(self, key: int) -> None:
        self.storage[self.bucket_hashing(key)][self.bucket_item_hashing(key)] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return self.storage[self.bucket_hashing(key)][self.bucket_item_hashing(key)]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)