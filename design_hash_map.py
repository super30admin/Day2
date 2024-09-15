"""
Create hashmap without using built in libraries
TIME COMPLEXITY: O(1) for all operations

SPACE COMPLEXITY:
Average case: O(nlogn)
Worst case: O(n^2)
Here n refers to the maximum value of the key

Yes, it passed all the test cases in leetcode.

Any problems faced? No
Any further optimization?
    for hash2 implementation, self-balancing tree will be optimum in terms of space and computation
"""

import math


class MyHashMap:

    def __init__(self):
        self.n = 1000000  # already given
        self.hash1_size = self.hash2_size = int(math.sqrt(self.n))
        self.data = [-1] * self.hash1_size
        self.zero_key_value = -1

    def put(self, key: int, value: int) -> None:
        if key == 0:
            self.zero_key_value = value
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)

        if self.data[hash1 - 1] == -1:
            self.data[hash1 - 1] = [-1] * self.hash2_size  # extra space is for the 0th element

        self.data[hash1 - 1][hash2 - 1] = value

    def get(self, key: int) -> int:
        if key == 0:
            return self.zero_key_value
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)

        if self.data[hash1 - 1] == -1:
            return -1
        return self.data[hash1 - 1][hash2 - 1]

    def remove(self, key: int) -> None:
        if key == 0:
            self.zero_key_value = -1
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)

        if self.data[hash1 - 1] == -1:
            return -1
        self.data[hash1 - 1][hash2 - 1] = -1

    def get_hash1(self, key):
        return key % self.hash1_size

    def get_hash2(self, key):
        return key // self.hash2_size

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)