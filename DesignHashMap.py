'''
Time Complexity:
put - O(1) 
get - O(1)
remove - O(1)

Space Complexity: O(n) where n is number of elements in hashmap
'''


class MyHashMap:

    def __init__(self):
        self.hashMap = 1000 * [-1]
        self.hash1 = 1000

    def put(self, key: int, value: int) -> None:
        index = key % self.hash1
        index2 = key // self.hash1
        if self.hashMap[index] == -1 and index == 0:
            self.hashMap[index] = [-1] * (1001)
        elif self.hashMap[index] == -1:
            self.hashMap[index] = [-1] * (1000)
        self.hashMap[index][index2] = value

    def get(self, key: int) -> int:
        if self.hashMap[key % self.hash1] == -1:
            return -1
        return self.hashMap[key % self.hash1][key//self.hash1]

    def remove(self, key: int) -> None:
        if self.hashMap[key % self.hash1] == -1:
            return -1
        self.hashMap[key % self.hash1][key//self.hash1] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
