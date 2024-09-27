'''
Time Complexity : O(1) for each operation
Space Complexity : O(n) for all elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:

'''

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Hashset = [None] * 1000
        self.buckets = 1000
        self.bucketItems = 1000

    def add(self, key: int) -> None:
        index1 = key % self.buckets
        if self.Hashset[index1] == None:
            self.Hashset[index1] = [None] * self.bucketItems

        index2 = key // self.bucketItems
        print(index2)
        self.Hashset[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = key % self.buckets

        if self.Hashset[index1] == None:
            return None
        else:
            index2 = key // self.bucketItems
            self.Hashset[index1][index2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """

        index1 = key % self.buckets
        index2 = key // self.bucketItems
        # return self.Hashset[index1] != None and self.Hashset[index1][index2]

        if self.Hashset[index1] == None:
            return False
        else:
            return self.Hashset[index1][index2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)