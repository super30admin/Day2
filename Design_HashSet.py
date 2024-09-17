class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.table = [None] * self.size

    def calculate_hash_value(self, key):
        """
        Function to calculate the hash value
        """
        return key % self.size

    def add(self, key: int) -> None:
        hash_value = self.calculate_hash_value(key)

        if self.table[hash_value] == None:
            self.table[hash_value] = [key]
        else:
            self.table[hash_value].append(key)

    def remove(self, key: int) -> None:
        hash_value = self.calculate_hash_value(key)

        if self.table[hash_value] != None:
            while key in self.table[hash_value]:
                self.table[hash_value] = [x for x in self.table[hash_value] if x != key]

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_value = self.calculate_hash_value(key)

        if self.table[hash_value] != None:
            return key in self.table[hash_value]
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)