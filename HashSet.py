// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        rows,cols = (1000,1001)
        self.arr = [[0 for i in range(cols)] for j in range(rows)]
        self.buckets = 1000
        self.bucketItems = 1001

    def add(self, key):
        bucket = key % self.buckets
        bucketItem = key/self.bucketItems
        self.arr[bucket][bucketItem] = 1

    def remove(self, key):
        bucket = key % self.buckets
        bucketItem = key / self.bucketItems
        self.arr[bucket][bucketItem] = 0

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        """
        bucket = key % self.buckets
        bucketItem = key / self.bucketItems
        if(self.arr[bucket][bucketItem] != 0):
            return True
        else:
            return  False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

