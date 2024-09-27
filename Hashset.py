# Time Complexity : O(1)
# Space Complexity : O(n)

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [-1] * ((10**6)+1)
        

    def add(self, key: int) -> None:
        self.hashset[key] = key
        

    def remove(self, key: int) -> None:
        self.hashset[key] = -1
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if self.hashset[key] != -1:
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)