# Time Complexity : O(1) for push, O(n) for pop because of the fact that we have to keep reversing the first stack
# Space Complexity : O(n) for the two stacks
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.firstStack = []
        self.secondStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """

        self.firstStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.secondStack:
            return self.secondStack.pop()

        while self.firstStack:
            self.secondStack.append(self.firstStack.pop())

        element = self.secondStack.pop()
        return element

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.secondStack:
            return self.secondStack[-1]

        while self.firstStack:
            self.secondStack.append(self.firstStack.pop())

        element = self.secondStack[-1]
        return element

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.firstStack or self.secondStack:
            return False
        else:
            return True

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()