"""
Time complexity:o(m * n) m=buckets and n=bucketItems
space complexity: o(m * n) m=buckets and n=bucketItems (stroage)

Explaination:
1. Intilasiing the storage as M * n
2.initalising two functions to calculate buckets (by calculating the module) and bucketitems (by dividing)
3. usually bucketitems will be the square root of the largest number



Code execution: Completed

"""


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1001
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def _bucket_index(self, key):
        return key % self.buckets

    def _bucketItems_index(self, key):
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket_index = self._bucket_index(key)
        bucketitem = self._bucketItems_index(key)
        if self.storage[bucket_index] == None:
            self.storage[bucket_index] = [False for i in range(self.bucketItems)]
        self.storage[bucket_index][bucketitem] = True

    def remove(self, key: int) -> None:
        bucket_index = self._bucket_index(key)
        bucketitem = self._bucketItems_index(key)
        if self.storage[bucket_index] != None:
            self.storage[bucket_index][bucketitem] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket_index = self._bucket_index(key)
        bucketitem = self._bucketItems_index(key)
        if self.storage[bucket_index] != None:
            return self.storage[bucket_index][bucketitem]
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)