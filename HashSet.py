# Time Complexity : O(1) for add, O(n) for remove, O(n) for contains
# Space Complexity : O(n) for our array of buckets
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keys = 1999
        self.arr = []
        for i in range(0, self.keys):
            self.arr.append([])

    def add(self, key: int) -> None:
        hashFunctionResult = key % self.keys
        bucketToUpdate = self.arr[hashFunctionResult]
        isKeyFound = False

        for existingKey in bucketToUpdate:
            if existingKey == key:
                isKeyFound = True

        if isKeyFound is False:
            bucketToUpdate.append(key)

    def remove(self, key: int) -> None:
        isKeyFound = False
        hashFunctionResult = key % self.keys
        bucketToUpdate = self.arr[hashFunctionResult]

        for existingKey in bucketToUpdate:
            if existingKey == key:
                isKeyFound = True

        if isKeyFound:
            bucketToUpdate.remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        isKeyFound = False
        hashFunctionResult = key % self.keys
        bucketToUpdate = self.arr[hashFunctionResult]

        for existingKey in bucketToUpdate:
            if existingKey == key:
                isKeyFound = True

        return isKeyFound

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)