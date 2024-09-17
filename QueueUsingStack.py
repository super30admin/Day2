# Time Complexity : Push, peek, empty - O(1), Pop - O(N) worst case O(1) ammortized

# Space Complexity : Push - O(N), pop peek empty - O(1)
# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# I have used a two stack approach in which push operations are done on the first stack and the pop and peek operations
# are done on the reverse stack(when not empty)
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # self.front keeps tack of the front value of the queue.
        self.stack = []
        self.reverse = []
        self.front = 0

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if not self.stack:
            self.front = x
        self.stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.reverse:
            while self.stack:
                self.reverse.append(self.stack.pop())
        return self.reverse.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        # if the elements are there on the reverse stack the last element will be popped o the self.front will be popped
        if self.reverse:
            return self.reverse[-1]
        return self.front

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.stack and not self.reverse:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()