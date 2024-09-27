# // Time Complexity: O(1) for all operations
# // Space Complexity:O(n) as it is directly proportional to the size of input
# // Did this code successfully run on Leetcode: Yes
# // Any problem you faced while coding this: No


# Used separate chaining and double hashing using 2 lists to attain O(1) in operations such as 
# add remove and contain.

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.bucketItems = 1000
        self.hashset = [None for _ in range(self.bucket)]

    def bucketIndex(self, key):
        return key % self.bucket

    def bucketItemIndex(self, key):
        return key//self.bucketItems

    def add(self, key: int) -> None:
        index1 = self.bucketIndex(key)
        index2 = self.bucketItemIndex(key)
        if not self.hashset[index1]:
            self.hashset[index1] = [False for _ in range(self.bucketItems)]
        self.hashset[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.bucketIndex(key)
        index2 = self.bucketItemIndex(key)
        if not self.hashset[index1]:
            return
        self.hashset[index1][index2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.bucketIndex(key)
        index2 = self.bucketItemIndex(key)
        if not self.hashset[index1]:
            return False
        return self.hashset[index1][index2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
