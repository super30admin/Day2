# // Time Complexity : Array approach: add, contains, remove: O(N)
# // Space Complexity : Depends on the size of the array that you choose. O(SIZE) + O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Will implement linkedList version and BST version in a later commit

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.SIZE = 100
        self.array = [[] for i in range(self.SIZE)]

    def add(self, key: int) -> None:
        insertAt = key % self.SIZE
                
        for i in range(len(self.array[insertAt])):
            if self.array[insertAt][i] == key:
                return
        self.array[insertAt].append(key)

    def remove(self, key: int) -> None:
        valueAt = key % self.SIZE
        
        for i in range(len(self.array[valueAt])):
            if self.array[valueAt][i] == key:
                del self.array[valueAt][i]
                return

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        valueAt = key % self.SIZE
        
        for i in range(len(self.array[valueAt])):
            if self.array[valueAt][i] == key:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)