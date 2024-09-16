#// Time Complexity :O(1) for add, contains and remove 
#// Space Complexity :O(n)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000000
        self.hashset=[-1]*self.size

    def add(self, key: int) -> None:
        self.hashset[key%self.size]=key

    def remove(self, key: int) -> None:
        self.hashset[key%self.size]=-1

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return self.hashset[key%self.size]!=-1


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)