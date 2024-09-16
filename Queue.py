"""
Time Complexity:
    * __init__  : O(1)
    * push      : O(n)
    * pop       : O(1)
    * peek      : O(1)
    * empty     : O(1)

Space Complexity:
    * __init__  : O(1)
    * push      : O(n)
    * pop       : O(1)
    * peek      : O(1)
    * empty     : O(1)

Pass on LeetCode: Yes
Problems Occurred: N/A
"""


class MyQueue:
    def __init__(self):
        self.temp = []
        self.data = []

    def push(self, x: int) -> None:
        while self.data:
            self.temp.append(self.data.pop())
        self.temp.append(x)
        while self.temp:
            self.data.append(self.temp.pop())

        return self.data

    def pop(self) -> int:
        return self.data.pop()

    def peek(self) -> int:
        if self.data:
            return self.data[-1]

    def empty(self) -> bool:
        return not self.data
