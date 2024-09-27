#TimeComplexity: O(1) 
#SpaceComplexity:O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Bucket=1000
        self.BucketItem=1000
        self.HashSet=[None for _ in range(self.Bucket)]
        
    def HashFn1(self,key):
        return key/self.Bucket
    
    def HashFn2(self,key):
        return key%self.BucketItem 
            

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1=self.HashFn1(key)
        index2=self.HashFn2(key)
        if not self.HashSet[index1]:
            self.HashSet[index1]=[None for _ in range(self.BucketItem)]
        self.HashSet[index1][index2]=True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1=self.HashFn1(key)
        index2=self.HashFn2(key)
        if self.HashSet[index1]:
            self.HashSet[index1][index2]=False
            

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index1=self.HashFn1(key)
        index2=self.HashFn2(key)        
        if self.HashSet[index1]:
            return self.HashSet[index1][index2]
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
