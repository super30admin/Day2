class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.range = 1000
        self.new = {}
        
    def get_hash(self, key: int) -> int:
        return key % self.range

    def add(self, key: int) -> None:
        if self.contains(key):
            return
        hash_key = self.get_hash(key)
        if hash_key not in self.new:
            self.new[hash_key] = []
        self.new[hash_key].append(key)
    
    def remove(self, key: int) -> None:
        if not self.contains(key):
            return
        hash_key = self.get_hash(key)
        self.new[hash_key].remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_key = self.get_hash(key)
        return hash_key in self.new and key in self.new[hash_key]
    
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)