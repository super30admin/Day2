'''
Time Complexity : O(1)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : Using 2D Array's in Python was very difficult
especially using Booleans, I had to use None to populate the main Hashtable as python does
not contain Null and use None in the inside HashSet.
In addition to this we cannot check a[outerIndex][innerIndex] so I had to check if the
a[outerIndex] is a list then perform further checks. So it was quite time consuming!

Solution: Create 2 lists which will form the base of the hasSet, use 2 hashing functions
-> bucketHash and bucketItemhash to compute the hash for a particular key.
For put check if bucketHash exists if not create a new array inside the bucketHash index in
the main array.
For remove set the value to False if the element does not exits.
'''

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for x in range(0, self.buckets)]

    def bucketHash(self, key: int) -> int:
        return key % self.buckets

    def bucketItemsHash(self, key: int) -> int:
        return int(key / self.bucketItems)

    def add(self, key: int) -> None:
        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)

        if self.storage[bucketKey] == None:
            self.storage[bucketKey] = ([False for x in range(0, self.bucketItems)])

        self.storage[bucketKey][bucketItem] = True

    def remove(self, key: int) -> None:
        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)
        # way to check if key is list is not present and
        # hence out of bounds in python
        if type(self.storage[bucketKey]) is list:
            if self.storage[bucketKey][bucketItem]:
                self.storage[bucketKey][bucketItem] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucketKey = self.bucketHash(key)
        bucketItem = self.bucketItemsHash(key)

        # need to write it this way for python
        return type(self.storage[bucketKey]) is list and self.storage[bucketKey][bucketItem]

obj = MyHashSet()
obj.add(1)
obj.add(8)
obj.add(20)
print("Element status " + str(obj.contains(8)))
obj.remove(20)