# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.arraySize = 1000
        self.hashList = [None]*self.arraySize
        
    def add(self, key: int) -> None:
        if self.contains(key) is False:
            hash1 = self.hashfn1(key)
            hash2 = self.hashfn2(key)
            if self.hashList[hash1] is None:
                if hash1 == 0: #Handling edge case
                    self.hashList[hash1] = [None]*(self.arraySize+1)
                else:
                    self.hashList[hash1] = [None]*self.arraySize
            self.hashList[hash1][hash2] = key
            
    def remove(self, key: int) -> None:
        if self.contains(key) is True:
            hash1 = self.hashfn1(key)
            hash2 = self.hashfn2(key)
            self.hashList[hash1][hash2] = None

    def contains(self, key: int) -> bool:
        hash1 = self.hashfn1(key)
        if self.hashList[hash1] is not None:
            hash2 = self.hashfn2(key)
            if self.hashList[hash1][hash2] is not None:
                return True
        return False
        
    def hashfn1(self,key: int) -> int:
        return key % self.arraySize
    
    def hashfn2(self,key: int) -> int:
        return key // self.arraySize