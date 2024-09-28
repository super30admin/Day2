#Time complexity for put and get: O(1) amortized
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.memory = [False]*self.buckets
        self.bucketItems = 1000
        
    def bucket(self,val):
        return val%self.buckets
    
    def bucketItem(self,val):
        return val/self.bucketItems
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bk = self.bucket(key)
        bkItem = self.bucketItem(key)
        if self.memory[bk] is False:
            if bk == 0:
                self.memory[bk] = [False]*(self.bucketItems+1)
            else:
                self.memory[bk] = [False]*self.bucketItems
            
        self.memory[bk][bkItem] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bk = self.bucket(key)
        bkItem = self.bucketItem(key)
        if self.memory[bk] is False:
            return
        self.memory[bk][bkItem] = False
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bk = self.bucket(key)
        bkItem = self.bucketItem(key)
        if self.memory[bk] is False:
            return False
        return self.memory[bk][bkItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)