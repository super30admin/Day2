# -*- coding: utf-8 -*-
"""
Time Complexity : push - O(n)
                  pop - O(n)
                  peek - O(n)
                  empty - O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

Problem:
Implement the following operations of a queue using stacks:
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
"""


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        for i in range(len(self.s1)):
            self.s2.append(self.s1.pop())
        p = self.s2.pop()
        for j in range(len(self.s2)):
            self.s1.append(self.s2.pop())
        return p
    def peek(self) -> int:
        """
        Get the front element.
        """
        for i in range(len(self.s1)):
            self.s2.append(self.s1.pop())
        p = self.s2[-1]
        for j in range(len(self.s2)):
            self.s1.append(self.s2.pop())
        return p

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.s1) == 0 and len(self.s2) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print(obj.peek())
print(obj.pop())
print(obj.empty())