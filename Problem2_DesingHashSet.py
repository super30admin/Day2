#Time Complexity: O(1) for all operations
#Space Complexity: O(n)
#Working on LeetCode: Yes

class MyHashSet:
    def __init__(self):
        self.size = 10**6
        self.hashset = [None]*self.size

    def hash_func(self, key):
        hash_func = key%self.size
        return hash_func
    
    def add(self, key):
        hash_func = self.hash_func(key)
        if self.hashset[hash_func] is None:
            self.hashset[hash_func] = [key]
        else:
            self.hashset[hash_func].append(key)
    
    def remove(self, key):
        hash_func = self.hash_func(key)
        if self.hashset[hash_func] is not None:
            while( key in self.hashset[hash_func]):
                self.hashset[hash_func].remove(key)
        
    def contains(self, key):
        hash_func = self.hash_func(key)
        if self.hashset[hash_func] is not None:
            return key in self.hashset[hash_func]
        return False
    

if __name__ == "__main__":
    hash_obj = MyHashSet()
    hash_obj.add(1)
    hash_obj.add(2)
    hash_obj.add(3)
    hash_obj.add(4)
    hash_obj.add(5)
    hash_obj.add(20**6)
    print(hash_obj.contains(2))
