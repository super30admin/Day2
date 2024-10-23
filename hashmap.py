#Time complexity: O(1) for all operations
#Space complexity: O(n) to store elements, No additional space
#Used double hashing to avoid collision
class MyHashMap:

    def __init__(self):
        self.primaryBucket = 1001
        self.secondaryBucket = 1000
        self.storage = [None] * self.primaryBucket
    
    def primaryHash(self, key):
        return key // self.primaryBucket
    
    def secondaryHash(self, key):
        return key % self.secondaryBucket
    
    def put(self, key: int, value: int) -> None:
        ph = self.primaryHash(key)
        if self.storage[ph] is None:
            self.storage[ph] = [-1]*self.secondaryBucket
        sh = self.secondaryHash(key)
        self.storage[ph][sh] = value    

    def get(self, key: int) -> int:
        ph = self.primaryHash(key)
        if self.storage[ph] is None:
            return -1
        sh = self.secondaryHash(key)
        return self.storage[ph][sh]  

    def remove(self, key: int) -> None:
        ph = self.primaryHash(key)
        if self.storage[ph] is None:
            return
        sh = self.secondaryHash(key)
        self.storage[ph][sh] = -1  

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,10)
obj.put(2,100)
obj.put(3,110)
obj.put(100,1110)
param_2 = obj.get(3)
print(param_2)
obj.remove(100)
print(obj.get(100))