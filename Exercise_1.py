"""
Time Complexity:
    - push - O(1)
    - pop - O(n)
    - peek - O(n)
    - empty - O(1)
Space Complexity:
    - Size of the array - dynamic O(n)
YES, The code successfully ran on Leetcode
The problem was on how to reduce the time

Approach - My approach is pretty clever, I made a stack class and used second stack as a helper stack to store
all the items in order to reverse and get the top.
"""

class Stack:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def isEmpty(self):
        if len(self.stack) == 0:
            return True
        return False

    def pop(self):
        if self.isEmpty:
            return self.stack.pop()

    def peek(self):
        return self.stack[-1]

    def size(self):
        return len(self.stack)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first = Stack()
        self.second = Stack()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.first.push(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        for i in range(self.first.size()):
            self.second.push(self.first.pop())
        ans = self.second.pop()
        for j in range(self.second.size()):
            self.first.push(self.second.pop())
        return ans

    def peek(self) -> int:
        """
        Get the front element.
        """
        # return self.first.stack[0]
        for i in range(self.first.size()):
            self.second.push(self.first.pop())
        ans = self.second.peek()
        for j in range(self.second.size()):
            self.first.push(self.second.pop())
        return ans

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.first.isEmpty()