'''Design Hashset'''
# Time Complexity : O(1)
# Space Complexity : O(N), 10^6 in this case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class HashSet(): 
    def __init__(self):
        """
        Initialize your  data structure here.
        """
        self.div = 1000  # square root of the range of values
        self.primary = [False for _ in range(1000)]

    def add(self, key: int) -> None:
        """
        value will always be non-negative.
        """
        idx = key % self.div
        sec_idx = key // self.div
        
        if not self.primary[idx]:
            if idx == 0:
                self.primary[0] = [False for _ in range(self.div+1)]
            else:
                self.primary[idx] = [False for _ in range(self.div)]
        self.primary[idx][sec_idx] = True

    def contains(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx = key % self.div
        sec_idx = key // self.div
        if self.primary[idx] and self.primary[idx][sec_idx]: 
            return True
        return False        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx = key % self.div
        sec_idx = key // self.div
        if self.primary[idx] and self.primary[idx][sec_idx]:
            self.primary[idx][sec_idx] = False        