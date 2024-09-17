# Time: O(N) 
class Bucket:
    def __init__(self):
        self.bucket = []

    def add(self, key):
        if key not in self.bucket:
            self.bucket.append(key)

    def remove(self, key):
        if key in self.bucket:
            self.bucket.remove(key)

    def contains(self, key):
        return key in self.bucket


class MyHashSet:
    def __init__(self):
        self.key_space = 7
        self.bucket = [Bucket() for i in range(self.key_space)]

    def add(self, key):
        hashkey = key % self.key_space
        self.bucket[hashkey].add(key)

    def remove(self, key):
        hashkey = key % self.key_space
        self.bucket[hashkey].remove(key)

    def contains(self, key):
        hashkey = key % self.key_space
        return self.bucket[hashkey].contains(key)



