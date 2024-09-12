'''
Time Complexity: O(1) for all operations
Space Complexity: O(n) n is the total number of keys possible
Run on Leetcode: YES
Problems: Difficult to choose between saving time or space for the operations. I went with saving time.
'''
class MyHashSet:

    def __init__(self):
        self.my_table = [-1] * 1000001
        

    def add(self, key: int) -> None:
        self.my_table[key] = key
        

    def remove(self, key: int) -> None:
        self.my_table[key] = -1
        

    def contains(self, key: int) -> bool:
        return self.my_table[key] != -1
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)