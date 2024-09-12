class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_ = []
        self.out = []
        self.front = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if not self.in_:
            self.front = x

        self.in_.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.out:
            while self.in_:
                self.out.append(self.in_.pop())
        return self.out.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.out:
            return self.out[-1]
        else:
            return self.front

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.in_ and not self.out)

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()