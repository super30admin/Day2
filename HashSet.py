# Time Complexity = O(1)
# Successfully run and compiled on Leetcode

class MyHashSet(object):

    def __init__(self):
        self.HashsetSize = 15000 #taking max size of Hashset
        self.Hashset = [[] for i in range(self.HashsetSize)] # declaring hashset data structure as list inside a list

    def hashfunc(self, key):
        return key % self.HashsetSize # code for hashing function

    def add(self, key):
        idx = self.hashfunc(key)
        if not key in self.Hashset[idx]:
        # add the key to hashset only if key already doesnot exist
            self.Hashset[idx].append(key)

    def remove(self, key):
        idx = self.hashfunc(key)
        if key in self.Hashset[idx]:
        # remove the key in hashset only if key already exists
            self.Hashset[idx].remove(key)

    def contains(self, key):
        idx = self.hashfunc(key)
        if key in self.Hashset[idx]: # checking if key is already present
            return True
        return False
