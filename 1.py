class MyHashSet:

    def __init__(self):
        self.b=1000
        self.bi= 1000
        self.s = [None]*self.b

    def hash1(self, key:int) -> int:
        return key%self.b
    
    def hash2(self, key:int) -> int:
        return key//self.bi

    def add(self, key: int) -> None:
        a = self.hash1(key)
        b = self.hash2(key)
        if self.s[a] is None:
            if a == 0:
                self.s[a] = [False] * (self.bi+1)
            else:
                self.s[a] = [False] * self.bi
                
        self.s[a][b] = True
    
    def remove(self, key: int) -> None:
        a = self.hash1(key)
        b = self.hash2(key) 
        if self.s[a]== None:
            return
        self.s[a][b]= False

    def contains(self, key: int) -> bool:
        a = self.hash1(key)
        b = self.hash2(key) 
        if self.s[a]== None:
            return False
        return self.s[a][b]
        








# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)