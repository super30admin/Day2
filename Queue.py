"""
Time Compleity: O(n) Push / O(1) Pop
Space Complexity: O(n)
Ran on leetcode successfully: 28ms

"""


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []
        self.front = []

    def push(self, x: int) -> None:

        if self.s1 == []:
            self.front = x
        self.s1.append(x)

    def pop(self) -> int:

        if self.s2 == []:
            while(self.s1 != []):
                self.s2.append(self.s1.pop())
        return self.s2.pop()

    def peek(self) -> int:

        if self.s2 != []:
            return self.s2[-1]
        return self.front

    def empty(self) -> bool:

        return (self.s1 == [] and self.s2 == [])
