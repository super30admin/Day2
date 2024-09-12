# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I got the error of index out of bound because of wrong way of list declaration. Updated that later and it worked.


# Your code here along with comments explaining your approach 

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.bucketItem = 1000
        self.hashset = [False for _ in range(self.bucket)]
        
    
    def hashfunc1(self, key):
        return key % self.bucket
    
    def hashfunc2(self, key):
        return key // self.bucketItem
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)
        if self.hashset[index1] == False:
            self.hashset[index1] = [False for _ in range(self.bucketItem)]
            print self.hashset
        self.hashset[index1][index2] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)
        if self.hashset[index1] == False:
            return
        self.hashset[index1][index2] = False
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index1 = self.hashfunc1(key)
        index2 = self.hashfunc2(key)
        
        return self.hashset[index1] and self.hashset[index1][index2]

hs = MyHashSet()
hs.add(1)
hs.add(2)
hs.add(3)
hs.remove(2)
print (hs.contains(2))
print (hs.contains(3))