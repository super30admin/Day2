"""
Time Complexity:
"m stands for hashspace"
add: O(m)
remove: O(m)
contains: O(m)

Space Complexity:
add: O(m*n)
remove: O(m*n)
contains: O(m*n)
"""
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash_space = 1000
        self.hash_dict = {}
        

    def add(self, key: int) -> None:
        hash_key = key % self.hash_space
        if hash_key not in self.hash_dict.keys():
            self.hash_dict[hash_key] = []
            self.hash_dict[hash_key].append(key)
        else:
            self.hash_dict[hash_key].append(key)
            self.hash_dict[hash_key] = list(set(self.hash_dict[hash_key]))

    def remove(self, key: int) -> None:
        hash_key = key % self.hash_space
        if hash_key in self.hash_dict.keys() and key in self.hash_dict[hash_key]:
            self.hash_dict[hash_key].remove(key)
        else:
            return None

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_key = key % self.hash_space
        if hash_key in self.hash_dict.keys() and key in self.hash_dict[hash_key]:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)