class MyQueue:

    def __init__(self):
        self.stack = []
        self.stack1 = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        if len(self.stack1)==0:
            while self.stack:
                popped = self.stack.pop()
                self.stack1.append(popped)
        popped_result = self.stack1.pop()
        return popped_result

    def peek(self) -> int:
        if len(self.stack1)==0:
            while self.stack:
                popped = self.stack.pop()
                self.stack1.append(popped)

        return self.stack1[-1]

    def empty(self) -> bool:
        if len(self.stack) == 0 and len(self.stack1)==0:
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()