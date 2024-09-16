class MyHashSet:

    def __init__(self):
        self.data = list()
        
    def checkdata(self,key):
        for x in self.data:
            if x == key:
                return True
        return False
    
    
    
    def add(self, key: int) -> None:
        if self.checkdata(key) == False:
            self.data.append(key)
            
        

    def remove(self, key: int) -> None:
        if self.checkdata(key) == True:
            self.data.remove(key)
        

    def contains(self, key: int) -> bool:
        return self.checkdata(key)
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
