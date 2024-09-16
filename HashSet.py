"""
Time Complexity:
    * __init__  : O(1)
    * add       : O(1)
    * remove    : O(1)
    * contains  : O(1)

Space Complexity:
    * __init__  : O(1)
    * add       : O(1)
    * remove    : O(1)
    * contains  : O(1)

Pass on LeetCode: Yes
Problems Occurred: N/A
"""


class MyHashSet:
    def __init__(self):
        self.keys = [False] * 1000001  # Max Size limit set by problem

    def add(self, key: int) -> None:
        self.keys[key] = True

    def remove(self, key: int) -> None:
        self.keys[key] = False

    def contains(self, key: int) -> bool:
        return self.keys[key]
