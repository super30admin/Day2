# Author: Vineet Khanna
# Hashset implementation.

class MyHashSet(object):

    def __init__(self):
        # Initialising array of 1000 arrays
        self.arr = [[] for i in range(1000)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #hash function is modulo 1000
        hashedkey = key % 1000
        if not self.contains(key):
            self.arr[hashedkey].append(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashedkey = key % 1000
        if self.contains(key):
            self.arr[hashedkey].remove(key)
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hashedkey = key % 1000
        if key in self.arr[hashedkey]:
            return True
        return False
    


hashSet = MyHashSet()
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    # returns true
hashSet.contains(3);    # returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    # returns true
hashSet.remove(2);          
hashSet.contains(2);    # returns false (already removed)
