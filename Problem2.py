class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1=[None for _ in range(1000000)]
        

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.s1[key] = True
        

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.s1[key]=None
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return self.s1[key]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)