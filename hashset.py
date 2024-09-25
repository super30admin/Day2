# Time Complexity: O(1)
# Space Complexity : O(1)

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.myHashSet = [False] * (10000000 - 1)

    def add(self, key):
        # Changing key index value of an myHashset to True
        self.myHashSet[key] = True
        """
        :type key: int
        :rtype: None
        """

    def remove(self, key):
        #  Changing current index value of key to False, as we wan tot remove it
        self.myHashSet[key] = False
        """
        :type key: int
        :rtype: None
        """

    def contains(self, key):
        # Checking boolean value in our data structure to see if that element is present at that index or not
        return self.myHashSet[key]
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)