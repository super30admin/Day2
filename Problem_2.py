"""

Time Complexity : O(1)
Space Complexity : O(n)
    
"""

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.matrix = [None] * (1000)
        self.size = 1000
        self.extra = False 
        
    def row(self, key):
        return key % self.size
    
    def col(self, key):
        return key // self.size
    
    def add(self, key: int) -> None:
        if key == 1000000:
            self.extra = True
            
        elif key < 1000000:
            r = self.row(key)
            c = self.col(key)
            
            if self.matrix[r] == None: 
                self.matrix[r] = [False] * self.size
                
            self.matrix[r][c] = True
            
    def remove(self, key: int) -> None:
        if key < 1000000:
            r = self.row(key)
            c = self.col(key)
            
            if not self.matrix[r]: return 
            self.matrix[r][c] = False 
        elif key == 1000000:
            self.extra = False 
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key == 1000000:
            return self.extra
        
        r = self.row(key)
        c = self.col(key)
        
        if not self.matrix[r]:
            return False 
        return self.matrix[r][c]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)