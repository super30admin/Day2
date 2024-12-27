# Similar to hashset but used enumerate to iterate the values in the array for the same index
# Time complexity is O(n) for all functions 
# Space complexity is O(buckets+keys)

#This code worked in leetcode

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.map = [[] for _ in range(self.size)]
    
    def _hash(self, key: int) -> int:
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        for i, (k, v) in enumerate(self.map[index]):
            if k == key:
                self.map[index][i] = (key, value)
                return
        self.map[index].append((key, value))

    def get(self, key: int) -> int:
        index = self._hash(key)
        for k, v in self.map[index]:
            if k == key:
                return v
        return -1


    def remove(self, key: int) -> None:
        index = self._hash(key)
        for i, (k, v) in enumerate(self.map[index]):
            if k == key:
                self.map[index].pop(i)
                return