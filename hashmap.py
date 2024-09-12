class MyHashMap:

    def __init__(self):
        self.size = 100000
        self.table = [-1] * self.size

    def put(self, key: int, value: int) -> None:
        self.table[key%self.size] = value

    def get(self, key: int) -> int:
        if self.table[key%self.size]!=-1:
            return self.table[key%self.size]
        return -1

    def remove(self, key: int) -> None:
        if self.table[key%self.size]!=-1:
            self.table[key%self.size]=-1


# Time complexity: O(N)
# Space Complexity: O(N)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
