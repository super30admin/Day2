class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket_len = 10 ** 3
        self.keyspace_len = 10 ** 3
        self.keyspace = [None for _ in range(self.keyspace_len)]

    def add(self, key: int) -> None:
        hash_key = key % self.keyspace_len
        if not self.keyspace[hash_key]:
            if hash_key == 0:
                self.keyspace[hash_key] = [False] * (self.bucket_len + 1)
            else:
                self.keyspace[hash_key] = [False] * self.bucket_len
        bucket_key = key // self.bucket_len
        self.keyspace[hash_key][bucket_key] = True

    def remove(self, key: int) -> None:
        hash_key = key % self.keyspace_len
        bucket_key = key // self.bucket_len
        if self.keyspace[hash_key]:
            self.keyspace[hash_key][bucket_key] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_key = key % self.keyspace_len
        if not self.keyspace[hash_key]:
            return False
        bucket_key = key // self.bucket_len
        return self.keyspace[hash_key][bucket_key]

"""
Space Complexity: O(n) 
Time Complexity:
add: O(1) 
remove: O(1) 
contains: O(1)
"""