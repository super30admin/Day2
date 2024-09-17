class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.bucketItem = 1000
        
        self.hashset = [None] * self.bucket
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = self.hashFunction1(key)
        index2 = self.hashFunction2(key)
        
        if not self.hashset[index1]:
            self.hashset[index1] = [False] * self.bucketItem
            
        self.hashset[index1][index2] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = self.hashFunction1(key)
        index2 = self.hashFunction2(key)
        
        if not self.hashset[index1]:
            return
            
        self.hashset[index1][index2] = False
        
    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index1 = self.hashFunction1(key)
        index2 = self.hashFunction2(key)
        
        return self.hashset[index1] and self.hashset[index1][index2]
        
        
    def hashFunction1(self, key):
        return key % self.bucket
    
    def hashFunction2(self, key):
        return key / self.bucketItem
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
