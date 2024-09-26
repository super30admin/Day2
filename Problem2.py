class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.li = []

    def add(self, key: int) -> None:
        if key not in self.li:
            self.li.append(key)

    def remove(self, key: int) -> None:
        if key in self.li:
            self.li.remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.li:
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
