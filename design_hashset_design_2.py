"""
Author: Srinidhi Bhat
Time Complexity: O(1) (can be O(N) for poorly designed hashmap)
Space Complexity: O(N+M) - Size of array plus max size of the bucket formed

Did it run on Leetcode:Yes
"""
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 2069
        self.table = [None]*(self.size)
        
    def add(self, key: int) -> None:
        hash_val = key%(self.size)
        
        if self.table[hash_val] == None:
            self.table[hash_val] = [key]
        else:
            self.table[hash_val].append(key)

    def remove(self, key: int) -> None:
        hash_val = key%(self.size)
        if self.table[hash_val]!=None:
            while key in self.table[hash_val]:
                self.table[hash_val].remove(key)
        
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_val = key%(self.size)
        
        if self.table[hash_val]!=None:
            return key in self.table[hash_val]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)