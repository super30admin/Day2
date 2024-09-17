class MyHashSet:

    def __init__(self):
        self.set=[]

    def add(self, key: int) -> None:
        if key in self.set:
            pass
        else:
            self.set.append(key)

    def remove(self, key: int) -> None:
        if key in self.set:
            self.set.remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.set
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)