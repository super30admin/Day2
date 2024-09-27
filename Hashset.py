#Time Complexity : O(N) due to in function
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : trying to do code in O(1) but didnot got any output

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = []

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key not in self.hashset:
            self.hashset.append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key in self.hashset:
            self.hashset.remove(key)
            

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        if key in self.hashset:
            return True
        else:
             return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)