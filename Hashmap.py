class MyHashMap:

    def __init__(self):
        self.mod = 769
        self.table = [Bucket() for i in range(self.mod)]

    def put(self, key: int, value: int) -> None:
        h = key%self.mod
        self.table[h].update(key,value)

    def get(self, key: int) -> int:
        h = key%self.mod
        return self.table[h].get(key)

    def remove(self, key: int) -> None:
        h = key%self.mod
        self.table[h].remove(key)
        
        
class Bucket:
    
    def __init__(self):
        self.bucket = []
        
    def get(self,key):
        for (k,v) in self.bucket:
            if k == key:
                return v
        return -1
    def update(self,key,value):
        check =0
        for i,k in enumerate(self.bucket):
            if key == k[0]:
                self.bucket[i] = (key,value)
                check =1
                break
        if check ==0:
            self.bucket.append((key,value))
    def remove(self,key):
        for i,kv in enumerate(self.bucket):
            if kv[0]==key:
                del self.bucket[i]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
