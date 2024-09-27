
class MyHashSet:
    import numpy as np
    
    def __init__(self):
        self.size = 10000
        self.buckets = [None] * self.size
    
    
    # Hash function to compute index
    def calculate_hash_index(self, key):
        return key % self.size

    def add(self, key):
        index = self.calculate_hash_index(key)
        if self.buckets[index] == None:
            self.buckets[index] = [key]
        else:
            self.buckets[index].append(key)
        

    def remove(self, key):
        index = self.calculate_hash_index(key)
        if self.buckets[index]!=None:
            while key in self.buckets[key]:
                self.buckets[index].remove(key)
        
    # return true if this set contains the specified element
    def contains(self, key):
        index = self.calculate_hash_index(key)
        if self.buckets[index] != None:
            return key in self.buckets[index]
        else:
            return False

    
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)