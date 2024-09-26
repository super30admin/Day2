# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
class MyHashSet:

    def __init__(self):
        self.li = []

    def add(self, key: int) -> None:
        if key not in self.li:
            self.li.append(key)
        

    def remove(self, key: int) -> None:
        if key in self.li:
            
            self.li.remove(key)

    def contains(self, key: int) -> bool:
        if key in self.li:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)