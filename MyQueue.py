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
        self.stack2 = self.stack1[::-1]

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        x2 = self.stack2.pop()
        self.stack1 = self.stack2[::-1]
        return x2

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack1[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.stack1 == []:
            return True
        else:
            return False