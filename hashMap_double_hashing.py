# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:
    def __init__(self):
        self.bucketSize = 1000
        self.bucket = [None]*1000

    def get_bucket_id(self, key):
        return key % 1000

    def get_sec_bucket_id(self, key):
        return key // self.bucketSize

    def put(self, key, value):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_sec_bucket_id(key)

        if not self.bucket[bucket_id]:
            if bucket_id == 0:
                self.bucket[bucket_id] = [None] * (self.bucketSize + 1)
            else:
                self.bucket[bucket_id] = [None] * self.bucketSize
        self.bucket[bucket_id][sec_bucket_id] = value

    def remove(self, key):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_sec_bucket_id(key)

        if not self.bucket[bucket_id]:
            return
        self.bucket[bucket_id][sec_bucket_id] = None

    def get(self, key):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_sec_bucket_id(key)

        if not self.bucket[bucket_id]:
            return -1
        if self.bucket[bucket_id][sec_bucket_id] is not None:
            return self.bucket[bucket_id][sec_bucket_id]
        return -1
