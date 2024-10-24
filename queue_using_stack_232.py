class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)
        while self.stack1:
            self.stack2.append(self.stack1.pop())

    def pop(self) -> int:
        return self.stack2.pop(0)

    def peek(self) -> int:
        return self.stack2[0]

    def empty(self) -> bool:
        return not self.stack2

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()