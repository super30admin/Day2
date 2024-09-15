'''
# Time complexity - O(1) Since there is no collision as we have defined our hash functions accordingly(mod and divide) for this problem
# Space complexity O(1) - The space does not grow with the algortithm run, its constant space
# Did this code successfully run on Leetcode : Yes
# Did you face problems while coding - No, as I coded this solution after the problem was discussed in the class

'''


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Using a 2D matrix of size(sqrt(max_size),sqrt(max_size)) so we dont have collisions
        # except for max_size where for zeroth column, we have to have (max_size)+1 rows to                 accomodate max_size number
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage  = [None for _ in range(self.buckets)]

    def getBucket(self, key):
        _bucket = key % self.buckets
        return _bucket


    def getBucketItem(self, key):
        _bucketItem = key // 1000
        return _bucketItem

    def add(self, key: int) -> None:

        # Add to the row and col corresponding to bucket, bucketItem respectively
        bucket_key = self.getBucket(key)
        bucket_item = self.getBucketItem(key)
        print(bucket_item)
        if not self.storage[bucket_key]:
            # handling edge case
            if bucket_key == 0:
                self.storage[bucket_key] = [None for _ in range(self.bucketItems+1)]
            else:
                self.storage[bucket_key] = [None for _ in range(self.bucketItems)]

        self.storage[bucket_key][bucket_item] = True



    def remove(self, key: int) -> None:

        # If the key is present, make its entry false

        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        # nothing to be removed
        if not self.storage[bucket]:
            return None

        self.storage[bucket][bucketItem] = False




    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        # check for the primary bucket first, if the entry is None, do an early return
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if not self.storage[bucket]:
            return False
        return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

