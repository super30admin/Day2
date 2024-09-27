# // Time Complexity :O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# type errors and syntactical changes

# // Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):

        self.bucketSize = 1000
        self.bucketItems =1000
        self.storage = [None]*self.bucketSize

    def bucket(self, key : int) -> int:
        return key % self.bucketSize

    def bucketItem(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucket_item = self.bucketItem(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [0]*(self.bucketItems + 1)
            else:
                self.storage[bucket] = [0] * self.bucketItems

        self.storage[bucket][bucket_item] = True


    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucket_item = self.bucketItem(key)
        if self.storage[bucket] is None:
            return None

        self.storage[bucket][bucket_item] = False

    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucket_item = self.bucketItem(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucket_item]



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(2)
# param_3 = obj.contains(2)
# obj.remove(2)