# Time Complexity : O(1) - get_main_ind, get_aux_ind, add, remove, contains
# Space Complexity : O(nm) - n : length of the primary array and m : length of secondary array (present at those entries of the primary array which has an entry). 
#                   But m,n are 1000 here (will always be some constatnt). So the CORRECT SC: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Didn't check if the primary ind was None or had secondary array in remove and contains function
#
# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_len = 1000
        self.aux_len = 1000
        self.arr = [None] * self.main_len
        
    # Primary Hash function
    def get_main_ind(self, key):
        return key % self.main_len
    
    # Secondary Hash function
    def get_aux_ind(self, key):
        return key // self.main_len

    # Adds element to Hashset (only sets True and don't store the actual value) by computing the primary and secondary indices. allocate array to primary ind if it's None. 
    def add(self, key: int) -> None:
        main_ind = self.get_main_ind(key)
        aux_ind = self.get_aux_ind(key)
        
        if self.arr[main_ind] is None:
            self.arr[main_ind] = [None] * self.aux_len
        self.arr[main_ind][aux_ind] = True

    # Removes element from Hashset (setting it to False) by getting primary and secondary indices and visit that entry.
    def remove(self, key: int) -> None:
        main_ind = self.get_main_ind(key)
        aux_ind = self.get_aux_ind(key)
        if self.arr[main_ind] is not None:
            self.arr[main_ind][aux_ind] = False

    # Checks if the entry corresponding to primary and secondary indices (computed using key) is True or not
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        main_ind = self.get_main_ind(key)
        aux_ind = self.get_aux_ind(key)
        if self.arr[main_ind] is not None and self.arr[main_ind][aux_ind] is True:
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
