# 705. Design HashSet
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket =1000
        self.bucketItem = 1000
        self.hashset=[[False for i in range(self.bucketItem)] for i in range(self.bucket)]
    
    def hash1(self, key):
        return key%self.bucket
    
    def hash2(self, key):
        return key//self.bucketItem

    def add(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        
        self.hashset[index1][index2] = True
        

    def remove(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        
        if self.hashset[index1][index2] == True:
            self.hashset[index1][index2] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        
        if self.hashset[index1][index2] == True:
            return True
        else:
            return False


# Time Complexity : O(1)
# Space Complexity : O(N+M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)