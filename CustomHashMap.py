import numpy as np

class MyHashMap:
    


    def __init__(self):
        self.primarysize=1000
        self.nestedsize=1000
        self.storagearray =np.full((1000,10001), None) 
        
    def modulusPrimaryArray(self,key: int):
        return key%self.primarysize

    def divideNestedArray(self,key: int):
        return int(key//self.nestedsize)

    def put(self, key: int, value: int) -> None:
        primary = self.modulusPrimaryArray(key)
        if(primary == None):
            return -1
        nested = self.divideNestedArray(key)
        if(nested == None):
            return -1
        self.storagearray[primary][nested] = value
        

    def get(self, key: int) -> int:
        primary = self.modulusPrimaryArray(key)
        nested = self.divideNestedArray(key)
        
        return self.storagearray[primary][nested]
        

    def remove(self, key: int) -> None:
        primary = self.modulusPrimaryArray(key)
        nested = self.divideNestedArray(key)
        self.storagearray[primary][nested] = None        
        return self.storagearray[primary][nested]

        
myobj = MyHashMap()
myobj.put(1,1)
myobj.put(2,2)
myobj.get(1)
myobj.get(3)
myobj.put(1,1)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)