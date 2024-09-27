class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.IN = []
        self.OUT = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.IN.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.OUT) == 0:
            while len(self.IN) != 0:
                self.OUT.append(self.IN.pop())
            return self.OUT.pop()
        else:
            return self.OUT.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.OUT) == 0:
            while len(self.IN) != 0:
                self.OUT.append(self.IN.pop())
            return self.OUT[-1]
        else:
            return self.OUT[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.OUT) == 0) and (len(self.IN) == 0):
            return True
        else:
            return False


"""
Time Complexity: 

Push: O(1)
Pop : Amortized O(1)

"""

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()Q