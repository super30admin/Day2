## Problem 2:
## Design Hashmap (https://leetcode.com/problems/design-hashmap/)
#1. Using the same method as taught in class for hashset, double hashing.
#2. Due to usecases for hashset we utilised a boolean for second has, we can instead store the value.
#3. Time is O(1)

class MyHashMap:

    def __init__(self):
        # self.hash = [[[False]*1000 for i in range(0,1000)] for i in range(1000)]
        self.hash = [[None]* 1000 for i in range(1000)]
        self.hash[0] = [None] *1001



    def put(self, key: int, value: int) -> None:
        self.hash[key % 1000][key // 1000] = value


    def get(self, key: int) -> int:
        if self.hash[key % 1000][key // 1000] is not None:
            return self.hash[key % 1000][key // 1000]
        return -1

    def remove(self, key: int) -> None:
        if self.hash[key % 1000][key // 1000] is not None:
            self.hash[key % 1000][key // 1000] = None



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
# class MyHashSet:

