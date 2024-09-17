# Space Complexity O(n)
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.size = 0

    def push(self, x: int) -> None:
        # Time Complexity O(1)
        self.stack1.append(x)

    def pop(self) -> int:
        # Time Complexity O(1) - Amortised and O(n) - worst case
        if not self.stack2:
            self.peek()

        return self.stack2.pop()

    def peek(self) -> int:
        # Time Complexity O(1) - Amortised and O(n) - worst case
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

        return self.stack2[-1]

    def empty(self) -> bool:
        # Time Complexity O(1)
        return len(self.stack1) + len(self.stack2) == 0
