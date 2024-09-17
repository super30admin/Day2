# Time Complexity :
#   Insert: O(1)
#   remove: O(1)
#   contains: O(1)
# Space Complexity:
#     O(n)
#  Did this code successfully run on Leetcode : Yes

class MyHashSet:

    def __init__(self):
        self.hashset = [None] * 1000
        self.hashsetSize = len(self.hashset)

    def add(self, key: int) -> None:
        firstKey = self.hashFirstIndex(key)
        secondKey = self.hashSecondIndex(key)

        if self.hashset[firstKey] is None:
            if firstKey == 0:
                self.hashset[firstKey] = [False] * 1001
            else:
                self.hashset[firstKey] = [False] * 1000

        self.hashset[firstKey][secondKey] = True

    def remove(self, key: int) -> None:
        firstKey = self.hashFirstIndex(key)
        secondKey = self.hashSecondIndex(key)

        if self.hashset[firstKey] is None:
            return

        self.hashset[firstKey][secondKey] = False

    def contains(self, key):
        firstKey = self.hashFirstIndex(key)
        secondKey = self.hashSecondIndex(key)

        if self.hashset[firstKey] is None:
            return False

        return self.hashset[firstKey][secondKey]

    def hashFirstIndex(self, key):
        return key % self.hashsetSize

    def hashSecondIndex(self, key):
        return key // self.hashsetSize

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
