# Time Complexity : O(1) to add, remove, contains
# Space Complexity : O(n) for all functions
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# Used Double Hashing Technique

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = [None] * 10 ** 3

    def add(self, key: int) -> None:
        hashq = key % 10 ** 3
        if self.buckets[hashq] is None:
            bucketlist = [False] * 1001
            self.buckets[hashq] = bucketlist
        hashr = key // 1000
        self.buckets[hashq][hashr] = True

    def remove(self, key: int) -> None:
        hashq = key % 10 ** 3
        if self.buckets[hashq] is None:
            return
        hashr = key // 1000
        self.buckets[hashq][hashr] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashq = key % 10 ** 3
        if self.buckets[hashq] is None:
            return False
        hashr = key // 1000
        return self.buckets[hashq][hashr]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)