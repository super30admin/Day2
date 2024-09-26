# Time Complexity - O(1) 
# Space Complexity - O(2n) -> O(n) (2 stacks to store values)
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def ifRequiredTransfer(self):
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
            
    def pop(self) -> int:
        self.ifRequiredTransfer()
        return self.stack2.pop()

    def peek(self) -> int:
        self.ifRequiredTransfer()
        return self.stack2[len(self.stack2) - 1]

    def empty(self) -> bool:
        return len(self.stack1) == 0 and  len(self.stack2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()