# // Time Complexity : O(1) for each function call made to MyHashMap class functions
# // Space Complexity : O(n) where n is the number of elements stored in the hashmap  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : missed thh edge case where key could be 10^6


# // Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for i in range(1000)]
        self.bucket = 1000
        self.bucketItem = 1000

    def getBucket(self, key):
        return key % self.bucket

    def getBucketItem(self, key):
        return key // self.bucketItem

    def add(self, key: int) -> None:
        """
        value will always be non-negative.
        """
        # function to calcualte the hash for the key
        bucket = self.getBucket(key)
        # double hashing to keep a smaller storage size
        bucketItem = self.getBucketItem(key)
        
        if self.arr[bucket] == None:
            if bucket == 0:
                self.arr[bucket] = [False for i in range(1001)]
            else:
                self.arr[bucket] = [False for i in range(1000)]
        self.arr[bucket][bucketItem] = True
            

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.arr[bucket] and self.arr[bucket][bucketItem]:
            self.arr[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        # if the key, val pair is found, it is returned else we get None and -1 is returned
        if self.arr[bucket] and self.arr[bucket][bucketItem]:
            return self.arr[bucket][bucketItem]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)