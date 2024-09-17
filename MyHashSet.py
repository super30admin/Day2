"""
Time complexity is O(1) for all opeartion add, remove and contains where n is no of keys stored in the bucket
Space complexity is O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :No

"""
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 1000
        self.bucketItems=1001 #this is to cover the edge case 1000000
        self.bucket= [None]*self.capacity
    
    def hash1(self,key):
        idx=key% self.capacity
        return idx
    
    def hash2(self,key):
        idx=key//self.bucketItems
        return idx
        

    def add(self, key: int) -> None:
        idx1=self.hash1(key)
        idx2=self.hash2(key)
        #if the indx1 of bucket is empty , created nested leaf
        if self.bucket[idx1] is None:
            self.bucket[idx1]=[None]*self.bucketItems
        #should change to True
        self.bucket[idx1][idx2]=True
        
    def remove(self, key: int) -> None:
        idx1=self.hash1(key)
        idx2=self.hash2(key)
        #if the indx1 of bucket is empty ,return nothing else set that index as False
        if self.bucket[idx1] is None:
            return
        else:
            self.bucket[idx1][idx2]=False
            
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        idx1=self.hash1(key)
        idx2=self.hash2(key)
        
        if self.bucket[idx1] is None:
            return False
        #return the bool if bucket not none
        return self.bucket[idx1][idx2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
