class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.instack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """

        popped = self.peek()
        return self.outstack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outstack) == 0:
            while (len(self.instack) != 0):
                self.outstack.append(self.instack.pop())
        return self.outstack[len(self.outstack) - 1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.outstack) == 0 and len(self.instack) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()