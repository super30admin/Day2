class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.map = [0]*self.modulo
        self.mapitems = [0]        

    def hash(self,key):
        return key%self.modulo

    def hash_nest(self,key):
        return key//self.modulo
        
        
    def add(self, key: int) -> None:

        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] == 0:
            if index == 0:
                self.map[index] = self.mapitems*(self.modulo + 1)
            else:
                self.map[index] = self.mapitems*self.modulo
        self.map[index][nested_index] = True        

    def remove(self, key: int) -> None:

        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] is 0:
            return
        self.map[index][nested_index] = 0     

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] is 0: 

            return False

        else:
            return self.map[index][nested_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)