class MyHashMap:
    def __init__(self):
        self.bucket_size = 1000
        self.buckets = [[] for _ in range(self.bucket_size)]

    def _get_bucket(self, key):
        return self.buckets[key % self.bucket_size]

    def _get_pair_idx(self, bucket, key):
        for idx in range(len(bucket)):
            if bucket[idx][0] == key:
                return idx

        return -1

    def put(self, key, value):
        bucket = self._get_bucket(key)
        element_idx = self._get_pair_idx(bucket, key)
        
        if element_idx == -1:
            bucket.append([key, value])
        else:
            bucket[element_idx][1] = value

    def get(self, key):
        bucket = self._get_bucket(key)
        element_idx = self._get_pair_idx(bucket, key)
        
        if element_idx == -1:
            return -1
        
        return bucket[element_idx][1]

    def remove(self, key):
        bucket = self._get_bucket(key)
        element_idx = self._get_pair_idx(bucket, key)
        
        if element_idx == -1:
            return
        
        del bucket[element_idx]