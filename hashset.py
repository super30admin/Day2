class MyHashSet(object):

    def __init__(self):
        self.bucket = [[] for i in range(1001)]
        """
        Initialize your data structure here.
        """
    def myhash1(self, key):
        index = key // len(self.bucket)
        return index
        
    def myhash2(self, key):
        index = key % 1000
        return index
        

    def add(self, key):
        index = self.myhash1(key)
        index2 = self.myhash2(key)
        if len(self.bucket[index]) == 0:
            self.bucket[index] = [False]*1000
        self.bucket[index][index2] = True
        
        """
        :type key: int
        :rtype: None
        """
        

    def remove(self, key):
        index = self.myhash1(key)
        index2 = self.myhash2(key)
        if len(self.bucket[index]) != 0:
            if self.bucket[index][index2]:
                self.bucket[index][index2] = False
            
            
        
        """
        :type key: int
        :rtype: None
        """
        

    def contains(self, key):
        index = self.myhash1(key)
        index2 = self.myhash2(key)
        if len(self.bucket[index]) != 0:
            if self.bucket[index][index2]:
                return True 
            else:
                return False
            
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)