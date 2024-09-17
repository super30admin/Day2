class MyHashSet:

    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets=1000
        self.bucketItems=1000
        self.storage = [[] for _ in range(self.buckets)]
        
    def bucket(self,value):
        return value%self.buckets
    
    def bucketItem(self,value):
        return value//self.buckets

    def add(self, value):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.bucket(value)
        bucketItem=self.bucketItem(value)
        if not self.storage[bucket]:
            
            self.storage[bucket] = [False]*self.bucketItems
            
        self.storage[bucket][bucketItem] = True
        #print(self.storage)

    def remove(self, value):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.bucket(value)
        bucketItem=self.bucketItem(value)
        if self.storage[bucket] and self.storage[bucket][bucketItem]:
            self.storage[bucket][bucketItem]=False
        

    def contains(self, value):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket=self.bucket(value)
        bucketItem=self.bucketItem(value)
        return self.storage[bucket] and self.storage[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.add(2002)
obj.add(3001)
obj.add(100)
obj.add(5002)
obj.remove(100)
param_3 = obj.contains(2002)
print(param_3)

#Time Complexity of add,pop,contains:O(1) Overall :O(1)
#Space Complexity:O(n)