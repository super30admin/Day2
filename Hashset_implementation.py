class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.nestedSize = 1000
        self.arr = [None for _ in range(self.size)]
        
    def create_nestedarr(self, hashval):
        if hashval == 0:
            return [None for _ in range(self.nestedSize +1)]
        else:
            return [None for _ in range(self.nestedSize)]
        
    def get_hashvalue(self, key):
        return key%self.size
    
    def get_nested_hashvalue(self, key):
        return key//self.nestedSize
        

    def add(self, key: int) -> None:
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        if self.arr[hashval] == None:
            self.arr[hashval] = self.create_nestedarr(hashval)
        self.arr[hashval][nestedhashval] = True
        

    def remove(self, key: int) -> None:
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        hash_bucket = self.arr[hashval]
        if hash_bucket != None and self.arr[hashval][nestedhashval] is not None:
            print(self.arr[hashval][nestedhashval])
            self.arr[hashval][nestedhashval] = None
            print(self.arr[hashval][nestedhashval])

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        hash_bucket = self.arr[hashval]
        if hash_bucket == None:
            return False
        elif self.arr[hashval][nestedhashval] is not None:
            return self.arr[hashval][nestedhashval]
        else:
            return False
        



# This algorithm takes O(1) complexity to add, remove or see if the particular key is present.
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)