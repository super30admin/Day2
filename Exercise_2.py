"""
Time Complexity:
    - Put - O(1)
    - get - O(1)
    - Remove - O(1)
    - Containe - O(1)
Space Complexity:
    - Size of the array - 10^3 * 10^3
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am making a hash function by modulus by size.
and then storing the key on the key // size index, if the key exist then update but if not then add it
into the bucket at double hashed index.
"""



class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None] * 1000

    def add(self, key: int) -> None:
        hashed = key % 1000
        if self.hashset[hashed] is None:
            if hashed == 0:
                self.hashset[hashed] = [False] * 1001
            else:
                self.hashset[hashed] = [False] * 1000
        double_hashed = key // 1000
        self.hashset[hashed][double_hashed] = True

    def remove(self, key: int) -> None:
        hashed = key % 1000
        if self.hashset[hashed] is not None:
            double_hashed = key // 1000
            self.hashset[hashed][double_hashed] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashed = key % 1000
        if self.hashset[hashed] is None:
            return False
        else:
            double_hashed = key // 1000
            return self.hashset[hashed][double_hashed]
