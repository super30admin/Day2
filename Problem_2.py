# https://leetcode.com/problems/design-hashset/
class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.hashtable = [None] * self.size
    
    def calc_hashvalue(self,key):
        return key%self.size
        

    def add(self, key: int) -> None:
        hash_value = self.calc_hashvalue(key)
        
        if self.hashtable[hash_value] == None:
            self.hashtable[hash_value] = [key]
        else:
            self.hashtable[hash_value].append(key)
        

    def remove(self, key: int) -> None:
        hash_value = self.calc_hashvalue(key)
        
        if self.hashtable[hash_value] is not None:
            while key in self.hashtable[hash_value]: 
                self.hashtable[hash_value].remove(key)
        

    def contains(self, key: int) -> bool:
        hash_value = self.calc_hashvalue(key)
        
        if self.hashtable[hash_value] is not None:
            return key in self.hashtable[hash_value]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)