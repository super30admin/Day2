num_bucket = 1000
bucket_size = 1001


class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.storage = [[None for i in range(1000)] for i in range(1000)]

    def hash1(self, key):
        return key % 1000

    def hash2(self, key):
        return key // 1000

    def add(self, key):
        """
        :type key: int
        :rtype: void
        """

        self.storage[self.hash1(key)][self.hash2(key)] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: void
        """
        # hashed, pos = self._get_hash_pos(key)
        self.storage[self.hash1(key)][self.hash2(key)] = False  # or None?

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """

        return self.storage[self.hash1(key)][self.hash2(key)] == True

    #time O(1)
    #space=O(2k)