class MyHashSet:

    def __init__(self):
        self.data=[None]*1000
    
#Time Complexity: O(1)
#space complexity: O(1)
    def add(self, key: int) -> None:
        firstHash=key%1000
        secondHash=key//1000
        if self.data[firstHash]==None:
            if firstHash==0:
                self.data[firstHash]=[False]*1001
            else:
                self.data[firstHash]=[False]*1000
        self.data[firstHash][secondHash]=True
#Time Complexity:O(1)
#space complexity:O(1) 
    def remove(self, key: int) -> None:
        firstHash=key%1000
        secondHash=key//1000
        if self.data[firstHash]==None:
            return
        self.data[firstHash][secondHash]=False
        
#Time Complexity:O(1)
#space complexity: O(1)
    def contains(self, key: int) -> bool:
        firstHash=key%1000
        secondHash=key//1000 
        if self.data[firstHash]==None or self.data[firstHash][secondHash]==False:
            return False
        return True 
        
        
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)