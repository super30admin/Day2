# Time Complexity : O(N)

# Space Complexity : O(N)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach -
#  I have used a two stack approach to pop except the last element from first stack into second stack.


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
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        val = self.stack1.pop()
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return val

    def peek(self) -> int:
        """
        Get the front element.
        """
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        val = self.stack1[0]
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return val

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.stack1:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()