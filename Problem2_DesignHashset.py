# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class MyHashSet:

    # Initialize primary and secondary array size (square root of total no of keys)
    def __init__(self):
        self.buckets = 1000
        self.bucket_items = 1001
        self.storage = [None] * self.buckets

    # Returns the index of the bucket
    def bucket(self, key) -> int:
        return int(key % self.buckets)

    # Returns the index of the bucket_items
    def bucket_item(self, key) -> int:
        return int(key / self.bucket_items)

    # add - Set the value of the computed hash address to True
    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)

        if self.storage[bucket] == None:
            self.storage[bucket] = [False] * self.bucket_items

        self.storage[bucket][bucket_item] = True

    # remove - Set the value of the computed hash address to False
    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)

        if self.storage[bucket] == None:
            return

        self.storage[bucket][bucket_item] = False

    # contains - Return the value of the computed hash address - True or False
    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)

        if self.storage[bucket] == None:
            return False

        return self.storage[bucket][bucket_item]
