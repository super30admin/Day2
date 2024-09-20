#Time Complexity = O(1)
# Maintaining two stacks,inserting elems in stack1 and if pop happens
# in between move all elements from stack1 to stack2 and pop from stack2
# insert always happens in stack 1 and pop always happens in stack 2

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if len(self.stack2) == 0:
            self.move_stack()
        return self.stack2.pop()

    def peek(self) -> int:
        if len(self.stack2) == 0:
            self.move_stack()
        return self.stack2[-1]

    def empty(self) -> bool:
        return len(self.stack1) == 0 and len(self.stack2) == 0

    def move_stack(self):
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()