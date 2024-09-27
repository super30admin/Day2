// Time Complexity :O(1), worst case O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.sets = []

    def add(self, key: int) -> None:
        if key not in self.sets:
            self.sets.append(key);
        

    def remove(self, key: int) -> None:
        if key in self.sets:
            self.sets.remove(key);
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.sets


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
