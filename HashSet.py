class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItem=1000
        self.storage=[None for i in range(self.buckets)]
    def hash1(self,val):
        return val%self.buckets
    def hash2(self,val):
        return val//self.bucketItem
    
    def add(self, key: int) -> None:
        bucket=self.hash1(key)
        bi=self.hash2(key)
        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket]=[False for i in range(self.bucketItem+1)]
            else:
                self.storage[bucket]=[False for i in range(self.bucketItem)]
        self.storage[bucket][bi]=True
        # print(self.storage[bucket][bi])

    def remove(self, key: int) -> None:
        bucket= self.hash1(key)
        bi=self.hash2(key)
        if self.storage[bucket]==None:
            pass
        else:
            self.storage[bucket][bi]=False

    def contains(self, key: int) -> bool:
        bucket= self.hash1(key)
        bi=self.hash2(key)
        if self.storage[bucket]==None:
            return False
        else:
            return self.storage[bucket][bi]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)