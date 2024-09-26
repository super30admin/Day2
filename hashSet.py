# Time Complexity :
# Add:     O(1)
# Remove:  O(1)
# Contains: O(1)

# Space Complexity : O(firstSize*secondSize)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Unclear about selecting the bound value for the hash functions.

# Approach: Uses double hashing with a 2D array which stores boolean values to indicate the presence of an element at the key.
# The first hash points to the location in the first array and the second is used to allot a position in case of collision.

# // Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.firstSize = 1000
        self.secondSize = 1000
        self.storage = [None]*self.firstSize

    def firstHash(self, key: int) -> int:
        return key % self.firstSize

    def secondHash(self, key: int) -> int:
        return key//self.firstSize

    def add(self, key: int) -> None:
        firstIndex = self.firstHash(key)
        secondIndex = self.secondHash(key)

        if self.storage[firstIndex] is None:
            self.storage[firstIndex] = [None]*self.secondSize

        self.storage[firstIndex][secondIndex] = True

    def remove(self, key: int) -> None:
        firstIndex = self.firstHash(key)
        secondIndex = self.secondHash(key)

        if self.storage[firstIndex] is not None:
            self.storage[firstIndex][secondIndex] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        firstIndex = self.firstHash(key)
        secondIndex = self.secondHash(key)
        return (self.storage[firstIndex] != None and self.storage[firstIndex][secondIndex])
