import math

class MyHashSet:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket_size = 1000
        self.bucket_item = 1000
        self.storage = [
                            [None for _ in range(self.bucket_item)] 
                            for _ in range (self.bucket_size)   
        ]
        self.storage[0].append(None)
        
        
    def hash_primary_index(self, key):       
        primary_index = key % self.bucket_size
        return int(primary_index)
    
    def hash_nested_index(self, key):   
        nested_index = (key // self.bucket_item)
        return int(nested_index)
    

    def add(self, key: int) :
        #  Perform double hashing to place the element on the correct index in the hashset
        # Primary index = modulus of the key with bucket_size
        # nested index = key/bucket_size (nested index)
        # Key = 3
        # Primary index = 3 % 1000 = 3 
        # Nested index = 3 / 1000 = 0.03 ~= 0
        # storage[3][0] = 3
        
        # Get primary index
        primary_index = self.hash_primary_index(key)
        nested_index = self.hash_nested_index(key)
        
        self.storage[primary_index][nested_index] = True
        
    
    def remove(self, key: int):
        primary_index = self.hash_primary_index(key)
        nested_index = self.hash_nested_index(key)
        self.storage[primary_index][nested_index] = False
        
        

    def contains(self, key: int) :
        """
        Returns true if this set contains the specified element
        """
        if self.storage[self.hash_primary_index(key)][self.hash_nested_index(key)] == None:
            return False
        else:
            return self.storage[self.hash_primary_index(key)][self.hash_nested_index(key)]
            
