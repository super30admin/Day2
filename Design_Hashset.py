#// Did this code successfully run on Leetcode :Yes
#// Any problem you faced while coding this :None


#// Your code here along with comments explaining your approach
#we have implemented hash set using double hashing technique.
#we have selected the number of buckets to be square root of range of the elements and bucketItem size to be the same.



class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets=1000
        self.bucketItem=1000
        self.storage=[None for i in range(self.buckets)]
    
    def bucket(self,key):
        return key%self.buckets
    
    def bucketItem2(self,key):
        return key//self.bucketItem

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #O(1) for time and space complexity
        bucket1=self.bucket(key)
        bucketItem1=self.bucketItem2(key)
        if self.storage[bucket1]==None:
            self.storage[bucket1]=[None for i in range(self.bucketItem)]
        self.storage[bucket1][bucketItem1]=key
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #O(1) for time and space complexity
        bucket1=self.bucket(key)
        bucketItem1=self.bucketItem2(key)
        if self.storage[bucket1]!=None:
            self.storage[bucket1][bucketItem1]=None

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        #O(1) for time and space complexity
        bucket1=self.bucket(key)
        bucketItem1=self.bucketItem2(key)
        if self.storage[bucket1]!=None and self.storage[bucket1][bucketItem1]==key:
            return True
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)