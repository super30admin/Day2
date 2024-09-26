class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1001
        #self.hashSet = [[] for i in range(self.buckets)]
        self.hashSet = [None] * self.buckets
        
    # hash 1
    def hash1(self, key):
        return key%self.buckets
    
    # hash 2
    def hash2(self, key):
        return key%self.bucketItems
    
    def add(self, key):
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)
        
        if (self.hashSet[bucket] is None):
            self.hashSet[bucket] = [None]*self.bucketItems
            
        self.hashSet[bucket][bucketItems] = True
    
    def remove(self, key):
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)
        
        if self.hashSet[bucket] is None:
            return
        
        self.hashSet[bucket][bucketItems] = False
    
    def contains(self, key):
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)
        
        if self.hashSet[bucket] is None:
            return False
        
        return self.hashSet[bucket][bucketItems]

# O(1) time for add/remove/contains
# O(n) for space