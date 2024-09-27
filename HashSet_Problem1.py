# implementation method 1
# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(1)     during all add, contains & remove operations
# Space Complexity: O(n)
class MyHashSet1:

    def __init__(self):
        self.max = 1000
        self.dataset = [[False for i in range(1001)] for j in range(1000)]

    def _hash_function(self, key):
        index = key % self.max
        subindex = key // self.max
        return index, subindex

    def add(self, key: int):
        index, subindex = self._hash_function(key)
        if not self.contains(key):
            self.dataset[index][subindex] = True

    def remove(self, key: int) -> None:
        index, subindex = self._hash_function(key)
        if self.contains(key):
            self.dataset[index][subindex] = False

    def contains(self, key: int):
        index, subindex = self._hash_function(key)
        if self.dataset[index][subindex]:
            return True
        else:
            return False


myHashSet1 = MyHashSet1()
myHashSet1.add(1)
myHashSet1.add(2)
myHashSet1.contains(1)
myHashSet1.contains(3)
myHashSet1.add(2)
myHashSet1.contains(2)
myHashSet1.remove(2)
myHashSet1.contains(2)


# implementation method 2
class MyHashSet2:

    def __init__(self):
        self.max = 1000
        self.dataset = [[] for i in range(1001)]

    def _hash_function(self, key):
        index = key % self.max
        return index

    def add(self, key):
        index = self._hash_function(key)
        if not self.contains(key):
            self.dataset[index].append(key)

    def remove(self, key: int) -> None:
        index = self._hash_function(key)
        if self.contains(key):
            for k, v in enumerate(self.dataset[index]):
                if v == key:
                    self.dataset[index].pop(k)

    def contains(self, key: int):
        index = self._hash_function(key)
        for v in self.dataset[index]:
            if v == key:
                return True
        else:
            return False


myHashSet2 = MyHashSet2()
myHashSet2.add(1)
myHashSet2.add(2)
myHashSet2.contains(1)
myHashSet2.contains(3)
myHashSet2.add(2)
myHashSet2.contains(2)
myHashSet2.remove(2)
myHashSet2.contains(2)
