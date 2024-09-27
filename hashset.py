# Time Complexity : O(1)
# Space Complexity : O(k^2) k=no of unique elements in the hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.bucket=1000
        self.bucket1=1000
        self.hash=[[] for _ in range(self.bucket)]   
        
    def getHashValue(self,key):
        
        return key%self.bucket
    
    def getHashBucket(self,key):
        return key//self.bucket1

    def add(self, key: int) -> None:
        
        hashVal=self.getHashValue(key)
        hashBucket=self.getHashBucket(key)
        
        if len(self.hash[hashVal])==0:
            self.hash[hashVal]=[False]*self.bucket1
            
        self.hash[hashVal][hashBucket]=True
            
        
    def remove(self, key: int) -> None:
        
        hashVal=self.getHashValue(key)
        
        
        if len(self.hash[hashVal])!=0:
            hashBucket=self.getHashBucket(key)
            self.hash[hashVal][hashBucket]=False
        
        
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        
        hashVal=self.getHashValue(key)
        
        if len(self.hash[hashVal])==0:
            return False
        
        hashBucket=self.getHashBucket(key)
        return self.hash[hashVal][hashBucket]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)