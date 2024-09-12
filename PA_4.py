#Leetcode 705 : Design HashSet
#Space Complexity - O(ParentBuckets * CHildBuckets) [Overall]
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.parentBuckets = 1000
        self.childBuckets = 1001
        self.hset = [None] * self.parentBuckets
    
    def getParentKey(self,key):
        #Time Complexity - O(1)
        return key % self.parentBuckets
    
    def getChildrenKey(self,key):
        #Time Complexity - O(1)
        return key // self.childBuckets

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #Time Complexity - O(1)
        parentKey = self.getParentKey(key)
        childKey = self.getChildrenKey(key)
        if self.hset[parentKey] == None:
            self.hset[parentKey] = [None] * self.childBuckets
        self.hset[parentKey][childKey] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #Time Complexity - O(1)
        parentKey = self.getParentKey(key)
        childKey = self.getChildrenKey(key)
        if self.hset[parentKey] != None:
            self.hset[parentKey][childKey] = None

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        #Time Complexity - O(1)
        parentKey = self.getParentKey(key)
        childKey = self.getChildrenKey(key)
        if self.hset[parentKey] != None:
            if self.hset[parentKey][childKey] != None:
                return True
        return False