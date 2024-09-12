class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []
        self.stack1 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.stack1:
            for x in range(len(self.stack)):
                i = self.stack.pop()
                self.stack1.append(i)
        return self.stack1.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.stack1:
            return self.stack[0]
        return self.stack1[len(self.stack1) - 1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.stack and not self.stack1:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

#time= amortized O(1)
# spac=O(1)