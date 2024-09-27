# Time Complexity : O(1)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
Create a Hashset using double hashing
Create a two dimensional array and initialize only 1 dimension at first
Based on the first hashing function determine to which bucket the element belongs 
Apply the second hashing function to determine the location of final storage

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketitems = 1001
        self.hashset = [None]* self.buckets
        
    def bucket(self,key):
        return key % self.buckets
    
    def bucketitem(self,key):
        return key /self.bucketitems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.bucket(key)
        bucketitem = self.bucketitem(key)
        if self.hashset[bucket] == None:
            self.hashset[bucket] = [False]*self.bucketitems
        
        self.hashset[bucket][bucketitem] = True
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.bucket(key)
        bucketitem = self.bucketitem(key)
        if self.hashset[bucket]!=None:
            self.hashset[bucket][bucketitem] = False
        
        
    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket = self.bucket(key)
        bucketitem = self.bucketitem(key)
        return self.hashset[bucket]!=None and self.hashset[bucket][bucketitem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)