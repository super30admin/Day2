class MyHashSet(object):

    # Design HashSet

    # Time Complexity : O(1)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    def __init__(self):
        self._hash = [[] for _ in range(1000)]
        
    # Check if key is not present and then add it from _hash array
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_key = key%1000
        if not self.contains(key):
            self._hash[hash_key].append(key)
        
    # Check if key is present and then remove it from _hash array
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if self.contains(key):
            hash_key = key%1000
            self._hash[hash_key].remove(key)
        
        
    # Check the key in _hash array
    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hash_key = key%1000
        return key in self._hash[hash_key]
        

# hashSet = MyHashSet()
# hashSet.add(1)
# hashSet.add(2)
# hashSet.contains(1)
# hashSet.contains(3)
# hashSet.add(2)
# hashSet.contains(2)
# hashSet.remove(2)         
# hashSet.contains(2)