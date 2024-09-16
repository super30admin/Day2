class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=100000
        self.hash_table=[None]*self.size
    def hash_function(self,key):
        hf= key%self.size
        return hf
        

    def add(self, key: int) -> None:
        x=self.hash_function(key)
        if self.hash_table[x]==None:
            self.hash_table[x]=[key]
        else:
            self.hash_table[x].append(key)
        
        

    def remove(self, key: int) -> None:
        x=self.hash_function(key)
        if self.hash_table[x]!=None:
            while key in self.hash_table[x]:
                self.hash_table[x].remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        x=self.hash_function(key)
        if self.hash_table[x]!=None:
            if key in self.hash_table[x]:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
