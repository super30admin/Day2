class MyHashSet:
    

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1001
        self.bucketItems = 1000
        self.storage = [None for i in range(self.buckets)]
        
    def hash1(self,key):
        return int(key%1000)
        
    def hash2(self,key):
        return int(key/1000)
        

    def add(self, key: int) -> None:
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        if not self.storage[indx1]:
            self.storage[indx1] = [None for i in range(self.bucketItems)]
        self.storage[indx1][indx2] = True
        
        
    def remove(self, key: int) -> None:
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        if not self.storage[indx1]:
            return
        self.storage[indx1][indx2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        if not self.storage[indx1]:
            return False
        else:
            return self.storage[indx1][indx2]
        
#TC: for all abstract functions we have O(1)
#SC: Assign 1001 memory locations initially for the keys and 
# later as each key comes in assign the next 1000 positions at every hash location to save space
# so time complexity is O(range of hashset)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)