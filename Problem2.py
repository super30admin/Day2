class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.my_list = [[ None for _ in range(1001) ] for _ in range(1000)]


    def add(self, key: int) -> None:
        hash1 = int(key%1000)
        hash2 = int(key/1000)
        self.my_list[hash1][hash2] = key


    def remove(self, key: int) -> None:
        hash1 = int(key%1000)
        hash2 = int(key/1000)
        self.my_list[hash1][hash2] = None



    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash1 = int(key%1000)
        hash2 = int(key/1000)
        if self.my_list[hash1][hash2] == key:
            return True
        else:
            return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
