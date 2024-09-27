class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []
        """
        Initialize your data structure here.
        """

    def push(self, x: int) -> None:
        while self.s1:
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop())
        """
        Push element x to the back of queue.
        """

    def pop(self) -> int:
        return self.s1.pop()
        """
        Removes the element from in front of queue and returns that element.
        """

    def peek(self) -> int:
        return self.s1[-1]
        """
        Get the front element.
        """

    def empty(self) -> bool:
        return not self.s1
        """
        Returns whether the queue is empty.
        """

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()