""""// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting optimized method


// Your code here along with comments explaining your approach"""


class MyHashSet:
    def __init__(self):
        self.size = 1000
        self.hash = [None for i in range(self.size)]

    def hashfunc(self, key):
        return key % self.size

    def hashitm(self, key):
        return key // self.size

    def add(self, key: int) -> None:
        bucket = self.hashfunc(key)

        # If array is not present at a bucket, create a new array of size 1000(1001 if bucket is 0)
        if (self.hash[bucket] == None):
            if bucket == 0:
                self.hash[bucket] = [None] * 1001
            else:
                self.hash[bucket] = [None] * 1000

        # get the index where to place value
        bitem = self.hashitm(key)
        self.hash[bucket][bitem] = key

    def remove(self, key: int) -> None:
        # If bucket exists remove value from array
        if self.hash[self.hashfunc(key)] != None:
            self.hash[self.hashfunc(key)][self.hashitm(key)] = None

    def contains(self, key: int) -> bool:
        if self.hash[self.hashfunc(key)] != None:
            return self.hash[self.hashfunc(key)][self.hashitm(key)]
            return None