# // Time Complexity : push = O(1), pop = O(n), peek = 0(n), empty = O(1)
# // Space Complexity : O(2n)
# // Did this code successfully run on Leetcode : Yes


class MyQueue:

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
        num = self.peek()
        self.stack2.pop()
        return num

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.stack2:
            while len(self.stack1):
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.stack1) or len(self.stack2)) == 0:
            return True
        else:
            return False

obj = MyQueue()
obj.push(1)
obj.push(2)
param_3 = obj.peek()
print(param_3)
param_2 = obj.pop()
print(param_2)
param_4 = obj.empty()
print(param_4)