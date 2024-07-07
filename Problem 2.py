class MyHashMap:

    def __init__(self):
        self.primary = 1000
        self.secondary = 1000
        self.storage = [None]*self.primary

    def getprimary(self, key: int) -> int:
        return key % self.primary

    def getsecondary(self, key: int) -> int:
        return key // self.secondary        

    def put(self, key: int, value: int) -> None:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            if p == 0:
                self.storage[p] = [None]*(self.secondary + 1)
            else:
                self.storage[p] = [None]*self.secondary
        self.storage[p][s] = value

    def get(self, key: int) -> int:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            return -1
        elif self.storage[p][s] == None:
            return -1
        else:
            return self.storage[p][s]

    def remove(self, key: int) -> None:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            return
        else:
            self.storage[p][s] = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)