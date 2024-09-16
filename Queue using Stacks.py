# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach
# Using 2 stacks, pop from first stack/list whenever the queue stack is empty while accessing the first element of the queue

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack_regular = []
        self.stack_queue = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack_regular.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.stack_queue.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.stack_queue == []:
            while self.stack_regular != []:
                self.stack_queue.append(self.stack_regular.pop())
        return self.stack_queue[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.stack_queue == [] and self.stack_regular == []


