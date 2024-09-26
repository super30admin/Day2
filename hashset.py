# Time Complexity: O(1) all operations take constant time lookup
# Space Complexity: O(N) where N is the range of elements/bucket size on avarage,
# in worst case assuming input is in the range 10^6, and each bucket has a secondary list created based on the inputs added N = 10^6

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketitems = 1000
        self.hashSet = [[] for i in range(self.bucket)]
        
    def hash1(self, key):
        return key % self.bucket
    
    def hash2(self, key):
        return key // self.bucketitems

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if not self.hashSet[bucket]:
            if bucket == 0:
               self.hashSet[bucket] = [False for i in range(self.bucketitems+ 1)] 
            else:
               self.hashSet[bucket] = [False for i in range(self.bucketitems)] 
        self.hashSet[bucket][bucketitem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if not self.hashSet[bucket]:
            return
        self.hashSet[bucket][bucketitem] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if not self.hashSet[bucket]:
            return False
        return self.hashSet[bucket][bucketitem]



obj = MyHashSet()
obj.add(5)
obj.add(10)
obj.add(1000)
obj.add(1000000)
obj.remove(5)
print(obj.contains(1000))
print(obj.contains(5))
