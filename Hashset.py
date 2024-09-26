class MyHashSet:
    def __init__(self):
        self.bucketlength = 1000
        self.bucket = [None] * self.bucketlength

    def hashkey(self, key):
        return key % self.bucketlength

    def doublehash(self, key):
        return key // self.bucketlength

    def add(self, key):
        hash_index = self.hashkey(key)
        double_hash_index = self.doublehash(key)
        if not self.bucket[hash_index] and hash_index == 0: 
            self.bucket[hash_index] = [False] * (self.bucketlength + 1)
        elif not self.bucket[hash_index]:
            self.bucket[hash_index] = [False] * self.bucketlength
        self.bucket[hash_index][double_hash_index] = True

    def remove(self, key):
        hash_index = self.hashkey(key)
        double_hash_index = self.doublehash(key)
        if self.bucket[hash_index]:
            self.bucket[hash_index][double_hash_index] = False

    def contains(self, key):
        hash_index = self.hashkey(key)
        double_hash_index = self.doublehash(key)
        if self.bucket[hash_index]:
            return self.bucket[hash_index][double_hash_index]