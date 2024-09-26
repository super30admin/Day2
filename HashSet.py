class MyHashSet(object):
    '''
    Solution:
    1. Consider a boolean 2D square matrix to fill in presence of an int after evaluating 2 Hash functions
        which are using modulo and divisor operators.
    2. Initilaize with 1D array of None values so that if that bucket is computed, then it can be filled with
        another dimension.
    3. Adding, Removing and Contains are achieved in constant time as we just need to calculate row index and
        column index and manipulate its corresponding boolean values.

    --- This code successfully ran on Leetcode
    '''

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketSize = 1001
        self.array = [None for i in range(self.buckets)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        bucketRowIndex = key % self.buckets
        bucketColIndex = int(key / self.bucketSize)
        if self.array[bucketRowIndex] == None:
            self.array[bucketRowIndex] = [False for i in range(self.bucketSize)]
        self.array[bucketRowIndex][bucketColIndex] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        bucketRowIndex = key % self.buckets
        bucketColIndex = int(key / self.bucketSize)
        if self.array[bucketRowIndex] != None:
            self.array[bucketRowIndex][bucketColIndex] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        # O(1) Time Complexity | O(1) Space Complexity
        bucketRowIndex = key % self.buckets
        bucketColIndex = int(key / self.bucketSize)
        return self.array[bucketRowIndex] != None and self.array[bucketRowIndex][bucketColIndex] == True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)