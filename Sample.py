# Implement Queue using Stacks

"""APPROACH 1"""


# Time Complexity : Push: O(n), Pop: O(1), Peek: O(1), Empty: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

        self.front = -1

    def push(self, x: int) -> None:
        # Push element x to the back of queue.
        """
        In this method, two stacks have been used.
        Stack1: Main stack to store the elements.
        Stack2: Supporting stack to temporary store the elements of stack2.

        When push method is called, all the elements of stack1 are popped and pushed to stack2.
        New item is pushed to stack1.
        ALl the elements of stack2 are popped and pushed back to stack1. So that top of the stack holds front or fist element.
        """

        while self.stack1:
            self.stack2.append(self.stack1.pop())
        self.stack1.append(x)
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        self.front += 1

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        ele = self.stack1.pop(self.front)
        self.front -= 1
        return ele

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack1[self.front]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return True if not self.stack1 else False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


"""APPROACH 2"""


# Time Complexity : Push: O(1), Pop: O(1) Average case or Amortized cost, Peek: O(1), Empty: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach
class MyQueue1:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        """
        In this method, All the elements of stack1 are moved to stack2. And stack2 top elements is returned
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.stack1 and not self.stack2

# Your MyQueue1 object will be instantiated and called as such:
# obj = MyQueue1()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()