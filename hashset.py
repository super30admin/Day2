# Time Complexity : O(1)
# Space Complexity : O(n + m), where n is the number of buckets and m is the number of elements inserted
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.num_buckets = 1000
        self.num_bucket_items = 1000
        self.buckets = [None for _ in range(self.num_buckets)]

    def bucket(self, key: int) -> int:
        return key % self.num_buckets

    def bucket_item(self, key: int) -> int:
        return key // self.num_bucket_items

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)

        if not self.buckets[bucket]:
            self.buckets[bucket] = [None for _ in range(self.num_bucket_items + 1)]

        self.buckets[bucket][bucket_item] = True

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)

        if not self.buckets[bucket]:
            return

        bucket_item = self.bucket_item(key)

        self.buckets[bucket][bucket_item] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.bucket(key)

        if not self.buckets[bucket]:
            return False

        bucket_item = self.bucket_item(key)

        return self.buckets[bucket][bucket_item]
