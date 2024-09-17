# Time Complexity : add: O(1), remove: O(1), contains: O(1)
# Space Complexity : O(buckets*bucketItems) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use a 2d array to create the hashset

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.buckets = 1000
        self.hashSet = [None] * self.buckets 
        self.bucketItems = 1000
               

    def add(self, key: int) -> None:
        
        index=self.hashfunc1(key)
        # if no value is present in the array create a list of 100 bucket items and store null, then map the 2d array value
        if self.hashSet[index] == None:
            self.hashSet[index] = [None] * self.bucketItems        
        index2 =self.hashfunc2(key)
        self.hashSet[index][index2] = True
        
        

    def remove(self, key: int) -> None:
        index=self.hashfunc1(key)
        if self.hashSet[index] == None:
            return None
        index2 = self.hashfunc2(key)
        self.hashSet[index][index2] = False
        

    def contains(self, key: int) -> bool:
        index = self.hashfunc1(key)
        index2 =self.hashfunc2(key)
        return self.hashSet[index] != None and self.hashSet[index][index2]
        
    def hashfunc1(self,value):
        return value % self.buckets
    
    def hashfunc2(self,value):
        return value // self.bucketItems
      


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)