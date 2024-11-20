class MyHashSet:

    def __init__(self):
        self.storage = [None]*1000
        self.bucket = 1000
        self.bucketItems = 1000
    

    def add(self, key: int) -> None:
        i = self.hashKey(key)
        if self.storage[i] == None:
            if i == 0:
                self.storage[i] = [None]*((self.bucketItems)+1)
            else:
                self.storage[i] = [None]*self.bucketItems
        j = self.nestedhashKey(key)
        self.storage[i][j] = True
        

    def remove(self, key: int) -> None:
        i = self.hashKey(key)
        if self.storage[i] == None:
            return
        else:
            j = self.nestedhashKey(key)
            self.storage[i][j] = False

    def contains(self, key: int) -> bool:
        i = self.hashKey(key)
        j = self.nestedhashKey(key)
        return self.storage[i]!=None and self.storage[i][j] 
    
    def hashKey(self,key):
        return key%self.bucket
    
    def nestedhashKey(self,key):
        return key//self.bucketItems