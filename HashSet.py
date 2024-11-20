# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        # Create list of lists
        self.hash_set = [[-1 for _ in range(0,1000)] for _ in range(0, 1001)]        
    
    def hashIndex(self, key):
        return int(key % 1000)
    
    def listIndex(self, key):
        return int(key / 1001)
    
    def add(self, key: int) -> None:
        self.hash_set[self.hashIndex(key)][self.listIndex(key)] = key
        
    def remove(self, key: int) -> None:
        self.hash_set[self.hashIndex(key)][self.listIndex(key)] = -1

    def contains(self, key: int) -> bool:
        return False if self.hash_set[self.hashIndex(key)][self.listIndex(key)] == -1 else True       


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(5)
obj.add(6)
obj.remove(5)
print(obj.contains(6))