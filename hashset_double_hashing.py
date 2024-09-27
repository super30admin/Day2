class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketitems = 1001
        self.storage = [None]*self.buckets
        
    def locate_bucket(self,key):
        return key % self.buckets
     
    def locate_bucketitems(self,key):
        return key // self.bucketitems      
 
    def add(self, key: int) -> None:
        bucket = self.locate_bucket(key)
        bucketitem = self.locate_bucketitems(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = [None] * self.bucketitems
        self.storage[bucket][bucketitem] = True  
         
    def remove(self, key: int) -> None:
        bucket = self.locate_bucket(key)
        bucketitem = self.locate_bucketitems(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketitem] = False
         
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.locate_bucket(key)
        bucketitem = self.locate_bucketitems(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketitem]
        
 
 
# # Your MyHashSet object will be instantiated and called as such:
# # obj = MyHashSet()
# # obj.add(key)
# # obj.remove(key)
# # param_3 = obj.contains(key)
