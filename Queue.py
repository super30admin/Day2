# Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# Time complexity: push: O(1); peek: O(1); pop: Amortized O(1); empty: O(1)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Approach: Used two stacks; one more stack for amortized O(1) pop operation

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mylistRear = []
        self.mylistFront = []
        self.front = 0

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if len(self.mylistRear) == 0:
            self.front = x
        self.mylistRear.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.mylistFront) == 0:
            while len(self.mylistRear) != 0:
                self.mylistFront.append(self.mylistRear.pop())
        return self.mylistFront.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.mylistFront) == 0:
            return self.front
        return self.mylistFront[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.mylistFront) == 0 and len(self.mylistRear) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()