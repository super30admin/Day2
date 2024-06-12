class MyHashSet:
    # Chaining using lists
    def __init__(self):
        self.arr = [[] for i in range(1000)]

    def add(self, key: int) -> None:
        hashKey = key % 1000
        if not self.contains(key):
            self.arr[hashKey].append(key)

    def remove(self, key: int) -> None:
        hashKey = key % 1000
        if self.contains(key):
            self.arr[hashKey].remove(key)

    def contains(self, key: int) -> bool:
        hashKey = key %1000
        return key in self.arr[hashKey]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)