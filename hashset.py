# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : 

# No, it failed and the status says runtime error and the Errormessage is as follows:
# IndexError: list assignment index out of range
#       self.hashset[index1][index2]=True
# Line xyz in add(Solution.py), basically line 36 in this file
# Please let me know what I am missing here :)

# // Any problem you faced while coding this : No, just that it doesn't pass all cases on leetcode

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.bucketItem = 1000 
        self.hashset = [[False] for i in range(self.bucket)]
        
    def hashfunc1(self, key:int):
        return key%self.bucket

    def hashfunc2(self, key:int):
        return key//self.bucketItem

    def add(self, key: int) -> None:
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)

        if(self.hashset[index1]==False):
            self.hashset[index1] = [self.bucketItem]
        
        self.hashset[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)

        if(self.hashset[index1]==False):
            return
        
        self.hashset[index1][index2] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)

        return self.hashset[index1] !=False and self.hashset[index1][index2]

# To test the code
hashSet = MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
print(hashSet.contains(1));    #returns true
print(hashSet.contains(3));    #returns false (not found)
hashSet.add(2);          
print(hashSet.contains(2));    #returns true
hashSet.remove(2);          
print(hashSet.contains(2));    #returns false (already removed)
