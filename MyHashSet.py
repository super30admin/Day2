class MyHashSet:
    size = 1000
    def singleHash(self,key):
        return (key % self.size)
    
    def doubleHash(self,key):
        return (key // self.size)
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000 
        self.bucketItems = 1001
        self.storage = [None for _ in range(self.buckets)]
        
        
    def add(self, key: int) -> None:
        sh = self.singleHash(key)
        dh = self.doubleHash(key)
        
        if self.storage[sh] == None:
            self.storage[sh] = [False for _ in range(self.bucketItems)]
        self.storage[sh][dh] =  True

    def remove(self, key: int) -> None:
        sh = self.singleHash(key)
        dh = self.doubleHash(key)
        
        if self.storage[sh] != None:
            self.storage[sh][dh] = False 
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        sh = self.singleHash(key)
        dh = self.doubleHash(key)
        
        if self.storage[sh] != None:
            return self.storage[sh][dh]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

if __name__ == "__main__":
    hs = MyHashSet()
    hs.add(5)
    hs.add(50)
    hs.add(78)
    res =hs.contains(50)
    print(res)
    hs.remove(50)
    res2 = hs.contains(50)
    print(res2)
    



