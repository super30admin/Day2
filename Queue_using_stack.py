#Time complexity: Amortized O(1)
#Space complexity: O(n)
class MyQueue:

    def __init__(self):
        self.pushStack = []
        self.popStack = []

    def push(self, x: int) -> None:
        self.pushStack.append(x)       

    def pop(self) -> int:
        if len(self.popStack) == 0:
            for i in range(len(self.pushStack)):
                self.popStack.append(self.pushStack.pop())
        return self.popStack.pop()


    def peek(self) -> int:
        if len(self.popStack) == 0:
            for i in range(len(self.pushStack)):
                self.popStack.append(self.pushStack.pop())
        return self.popStack[-1]

    def empty(self) -> bool:
        return True if len(self.popStack) == 0 and len(self.pushStack) == 0 else False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()