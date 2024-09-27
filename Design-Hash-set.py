# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.main_list = [None] * self.size
        
    def hash_func(self, key):
        return (key % self.size)
        
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_func(key)
        if self.main_list[index] == None:
            self.main_list[index] = [key]
        else:
            self.main_list[index].append(key)
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_func(key)
        
        if self.main_list[index] != None:
            while key in self.main_list[index]:
                self.main_list[index].remove(key)
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index = self.hash_func(key)
        
        if self.main_list[index] != None:
            return key in self.main_list[index]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)