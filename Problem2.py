#implement hashset 
#approach 1 : linear chaining 
class MyHashSet(object):
    
    def __init__(self):
        self.numbuckets = 10000
        self.hash = [[] for i in range(self.numbuckets)]

    def add(self,key):
        index = key % self.numbuckets
        if key not in self.hash[index]:
            self.hash[index].append(key)

    def remove(self,key):
        index = key % self.numbuckets
        if key in self.hash[index]:
            self.hash[index].remove(key)

    def contains(self,key):
        index = key % self.numbuckets
        if key in self.hash[index]:
            return True
        return False
    

obj = MyHashSet()
obj.add(5)
obj.add(6)
print(obj.contains(5))
obj.remove(6)
print(obj.contains(6))
