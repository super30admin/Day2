class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.len_hash = 1000
        self.buckets = [[] for i in range(self.len_hash)]

    def __get_hash_key(self, key) -> int:
        return key % self.len_hash

    def add(self, key: int) -> None:
        hash_key = self.__get_hash_key(key)
        if key not in self.buckets[hash_key]:
            self.buckets[hash_key].append(key)

    def remove(self, key: int) -> None:
        hash_key = self.__get_hash_key(key)
        if key in self.buckets[hash_key]:
            self.buckets[hash_key].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_key = self.__get_hash_key(key)
        if key in self.buckets[hash_key]:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
