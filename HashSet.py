class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.hashtab = [None for i in range(self.buckets)]
        
    def getBucket(self,key):
        return key % self.buckets
    
    def getBucketItem(self,key):
        return int(key / self.bucketItems)

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        #print('bucket:',bucket)
        #print('bucketItem:',bucketItem)
        #print('self.hashtab[bucket]:',self.hashtab[bucket])
        if (self.hashtab[bucket] is None):
            if(bucket == 0):
                self.hashtab[bucket] = [False for i in range(self.bucketItems + 1)] 
            else:    
                self.hashtab[bucket] = [False for i in range(self.bucketItems)] 
        #print(self.hashtab[bucket])
        self.hashtab[bucket][bucketItem] = True
        
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if (self.hashtab[bucket] is None):
            return
        self.hashtab[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if (self.hashtab[bucket] is None):
            return False
        return self.hashtab[bucket][bucketItem]    
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1000)
obj.add(2000)
obj.add(3000)
obj.remove(1000)
obj.add(4000)
element1 = obj.contains(1000) 
element2 = obj.contains(4000) 
element3 = obj.contains(5000)
print(element1)
print(element2)
print(element3)