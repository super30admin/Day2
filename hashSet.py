# // Time Complexity : O(1) for each operation
# // Space Complexity : O(1) constant since we are assuming million elements maximum
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# For million elements of set we created the nested array of 1000*1000 size
# We just initialize primary array and then created nested arry for only values that are hashed using hash1 function
# we used two hashing functions.


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [0]*self.buckets
        
    def hash1(self,key):
        return key%1000
    
    def hash2(self,key):
        return key//1000
    
    def add(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] == 0:
            self.storage[index1] = [False]*(self.bucketItems+1)
        self.storage[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] == 0:
            return
        self.storage[index1][index2] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] == 0:
            return False
        return self.storage[index1][index2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)