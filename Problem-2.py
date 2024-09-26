class MyHashSet(object):
#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.outsize=1000
        self.insize=1001
        self.hashset=[False]*self.outsize
    
    def _createArray(self):
        array=[False]*self.insize
        return array

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        outindex=key%self.outsize
        inindex=key/self.insize
        if(self.hashset[outindex]):
            self.hashset[outindex][inindex]=True
        else:
            self.hashset[outindex]=self._createArray()
            self.hashset[outindex][inindex]=True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        outindex=key%self.outsize
        inindex=key/self.insize
        if(self.hashset[outindex] and self.hashset[outindex][inindex]):
            self.hashset[outindex][inindex]=False
        else:
            return

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        outindex=key%self.outsize
        inindex=key/self.insize
        if(self.hashset[outindex] and self.hashset[outindex][inindex]):
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)