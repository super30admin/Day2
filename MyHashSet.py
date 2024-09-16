# // Time Complexity : O(1)
# // Space Complexity : O(n * k) - if n is the initial size of the bucket, then n * (number of buckets whose bucket items are not empty)
# doubtful on the space complexity - please review.
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No, reimplementation using buckets method taught in class.
class MyHashSet(object):

    def __init__(self):
        self.bucket_size = 1000
        self.bucket = [None] * self.bucket_size

    def hashFunction(self, key):
        bucket_index = key % self.bucket_size
        bucket_item_index = key / self.bucket_size
        return bucket_index, bucket_item_index

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_index, bucket_item_index = self.hashFunction(key)
        if self.bucket[bucket_index] is None:
            if bucket_index == 0:
                self.bucket[bucket_index] = [False] * (self.bucket_size + 1)
            else:
                self.bucket[bucket_index] = [False] * self.bucket_size
        self.bucket[bucket_index][bucket_item_index] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_index, bucket_item_index = self.hashFunction(key)
        if self.bucket[bucket_index] is not None:
            self.bucket[bucket_index][bucket_item_index] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket_index, bucket_item_index = self.hashFunction(key)
        if self.bucket[bucket_index] is not None:
            return self.bucket[bucket_index][bucket_item_index]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
