class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        while self.outStack:
            self.inStack.append(self.outStack.pop())
        self.inStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        while self.inStack:
            self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.inStack and not self.outStack

# Your MyQueue object will be instantiated and called as such:
queue = MyQueue()
queue.push(1)
queue.push(2)
print("Peeked value:", queue.peek()) #returns 1
print("Popped value:",queue.pop())   #returns 1
print("Queue is empty:",queue.empty()) #returns false