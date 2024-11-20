# Time Complexity: O(n)
# Space Complexity: O(n)
class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.hashset = [[] for i in range(self.size)]

    def _hash(self, key):
        return key%self.size
    
    def add(self, key: int) -> None:
        idx = self._hash(key)

        if not self.hashset[idx]:
            self.hashset[idx].append(key)
        else:
            if key not in self.hashset[idx]:
                self.hashset[idx].append(key)

    def remove(self, key: int) -> None:
        idx = self._hash(key)

        if self.hashset[idx]:
            if key in self.hashset[idx]:
                self.hashset[idx].pop(self.hashset[idx].index(key))

    def contains(self, key: int) -> bool:
        idx = self._hash(key)

        if not self.hashset[idx]:
            return False
        else:
            if key in self.hashset[idx]:
                return True
            else:
                return False

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.add(3)
print(obj.contains(2))
print(obj.contains(21))
print(obj.hashset[:11])
obj.remove(1)
obj.remove(10)
print(obj.hashset[:11])
# obj.remove(key)
# param_3 = obj.contains(key)