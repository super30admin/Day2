/ Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.primaryArray = [None]* 1000
        
    def getBucket(self,key):
        return key%1000
    def getBucketitems(self,key):
        return key//1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.getBucket(key)
        bucketItem=self.getBucketitems(key)
        if(self.primaryArray[bucket]==None):
            if bucket==0:
                self.primaryArray[0]=[False]*1001
            else:
                self.primaryArray[bucket]=[False]*1000
        self.primaryArray[bucket][bucketItem] = True
                
            
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.getBucket(key)
        bucketItem=self.getBucketitems(key)
        if self.primaryArray[bucket] is not None:
            self.primaryArray[bucket][bucketItem] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket=self.getBucket(key)
        bucketItem=self.getBucketitems(key)        
       

        if self.primaryArray[bucket]  is None:
            return False
        else:
            return self.primaryArray[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)