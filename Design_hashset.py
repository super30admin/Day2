# Time Complexity: add remove and look up is O(1)
# Space Complexity: O(n)

# Approach to solve this problem:
class MyHashSet:

    def __init__(self):
        self.size = 1000                      # Initialize size 
        self.table = [None] * self.size       # Make a hashset
        
    def hash_value(self, key: int):           # Function to calculate the hashvalue of the key
        return key % self.size
        
    def add(self, key: int) -> None:          # Function to add
        hv = self.hash_value(key)
        
        if self.table[hv] == None:            # Go to the index, if none, append
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)        
            
    def remove(self, key: int) -> None:       # Function to remove
        hv = self.hash_value(key)
        if self.table[hv] != None:            # If none nothing to remove
            while key in self.table[hv]:
                self.table[hv].remove(key)

    def contains(self, key: int) -> bool:     # It will look for a value, if found True
        hv = self.hash_value(key)             # else False
        
        if self.table[hv] != None:
            return key in self.table[hv]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)