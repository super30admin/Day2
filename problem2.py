# Time Complexity :
	# add: O(1) [Amortized]
	# remove: O(1)
	# contains: O(1)
# Space Complexity : O(n^(1/2)) where n is the range of inputs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None for _ in range(1000)]
        

    def add(self, key: int) -> None:
        if self.hashset[key//1000] is None:
            self.hashset[key//1000] = [False for _ in range(1000)]
            
        self.hashset[key//1000][key%1000] = True

    def remove(self, key: int) -> None:
        if self.hashset[key//1000] is not None:
            self.hashset[key//1000][key%1000] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if self.hashset[key//1000] is not None:
            return self.hashset[key//1000][key%1000] == True
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)