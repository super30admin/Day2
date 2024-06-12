# Created by Aashish Adhikari at 2:25 PM 12/23/2020

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        import math
        self.div = int(math.sqrt(100000))
        self.first_level = [False for idx in range(self.div)]


    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        first = key % self.div
        if self.first_level[first] is False:
            self.first_level[first] = [False for idx in range(self.div + 1)] # VVI: Notice + 1 to accomodate 100000 as well.

        second = key / self.div
        # Now add
        self.first_level[first][second] = True


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        first = key % self.div
        if self.first_level[first] is not False:
            second = key / self.div
            self.first_level[first][second] = False


    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        first = key % self.div
        if self.first_level[first] is not False:
            second = key / self.div
            if self.first_level[first][second] is False:
                return False
            return True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)