# Time Complexity : O(n) as I am using if key in hashset
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : It took me some time to figure out 
# Redo according to solution discussed in class
class MyHashSet:

    def __init__(self):
        self.hashset = []
        
    def add(self, key: int) -> None:
        self.hashset.append(key)
        
    def remove(self, key: int) -> None:
        if key in self.hashset:
            self.hashset = list(set(self.hashset))
            del self.hashset[self.hashset.index(key)]

    def contains(self, key: int) -> bool:
        if key in self.hashset:
            return True
        else:
            return False
        