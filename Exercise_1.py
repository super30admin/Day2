class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 997
        self.buckets = [[] for i in range(self.size)]
        
    def hashKey(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        value = self.hashKey(key)
        if key not in self.buckets[value]:
            self.buckets[value].append(key)

    def remove(self, key: int) -> None:
        value = self.hashKey(key)
        if key in self.buckets[value]:
            self.buckets[value].remove(key)
        
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        value = self.hashKey(key)
        return key in self.buckets[value]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)