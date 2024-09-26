## Time Complexity-> O(1)
## Space Complexity -> O(n)


class MyHashSet:
    #HashCode = 1000
    def __init__(self):
        self.hashset = [None]*10000
    
    def GetPrimaryHash(self, key):
        return key % 10000
    
    def GetSecondaryHash(self,key):
        return key//10000
    def add(self, key: int) -> None:
        if self.hashset[self.GetPrimaryHash(key)] == None:
            temp = [None]*10000
            temp[self.GetSecondaryHash(key)] = True
            self.hashset[self.GetPrimaryHash(key)] = temp
        else:
             self.hashset[self.GetPrimaryHash(key)][self.GetSecondaryHash(key)] = True
            
    
    def remove(self, key: int) -> None:
        if self.hashset[self.GetPrimaryHash(key)] == None:
            pass
        else:
            self.hashset[self.GetPrimaryHash(key)][self.GetSecondaryHash(key)] = None
            
    
    def contains(self, key: int) -> bool:
        if self.hashset[self.GetPrimaryHash(key)] == None:
            return False
        return self.hashset[self.GetPrimaryHash(key)][self.GetSecondaryHash(key)]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
