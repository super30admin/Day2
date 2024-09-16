"""
Design Hashset
"""
"""
Time Complexity:
Add: O(1)
Remove: O(1)
Contains: O(1)
"""

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSet = [False] * 1000001

    def add(self, key: int) -> None:
        # update the value to True
        self.hashSet[key] = True

    def remove(self, key: int) -> None:
        # update the value to False
        self.hashSet[key] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        # return the value at given key
        return self.hashSet[key]
    
# all the operations have O(1) complexity

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)