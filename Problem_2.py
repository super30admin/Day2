"""

    Student : Shahreen Shahjahan Psyche
    The Code Ran Successfully in Leetcode for all the test cases.
    Memory Complexity : O(N^(1/2))
    Average Time Complexity:
        def add : O(1)
        def contains : O(1)
        def remove: O(1)
    I have used chaining methods to store the values if there are collisions.

"""

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.records = [[] for _ in range(1000)]
        
    def hash_func(self, key):
        return hash(key) % len(self.records)

    def add(self, key: int) -> None:
        
        get_index = self.hash_func(key)
        
        if self.records[get_index] is None:
            self.records[get_index].append(key)
        else:
            
            for i in self.records[get_index]:
                if i == key:
                    return
            
            self.records[get_index].append(key)  
        

    def remove(self, key: int) -> None:
        
        get_index = self.hash_func(key)
        
        if self.records[get_index] is None:
            return
        else:
            for i in self.records[get_index]:
                if i == key:
                    self.records[get_index].remove(i)
        return
            
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        get_index = self.hash_func(key)
        
        if self.records[get_index] is None:
            return False
        else:
            for i in self.records[get_index]:
                if i == key:
                    return True
            return False
        
        