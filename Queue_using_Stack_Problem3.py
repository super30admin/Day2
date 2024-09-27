# Space Complexity: O(2n)
# Did this code successfully run on Leetcode: Yes

class Stack:
    def __init__(self):
        self.items = []

    def push(self, value):
        self.items.append(value)

    def pop(self):
        if self.items:
            return self.items.pop()

    def is_empty(self):
        return self.items == []

    def peek(self):
        return self.items[-1]


class MyQueue:

    def __init__(self):
        self.stack1 = Stack()
        self.stack2 = Stack()

    # Time Complexity: O(1)
    def push(self, x: int) -> None:
        self.stack1.push(x)

    # Time Complexity: O(n)
    def pop(self) -> int:
        if self.stack2.is_empty():
            while not self.stack1.is_empty():
                self.stack2.push(self.stack1.pop())
        return self.stack2.pop()

    # Time Complexity: O(n)
    def peek(self) -> int:
        if self.stack2.is_empty():
            while not self.stack1.is_empty():
                self.stack2.push(self.stack1.pop())
        return self.stack2.peek()

    # Time Complexity: O(1)
    def empty(self) -> bool:
        if self.stack1.is_empty() and self.stack2.is_empty():
            return True
        else:
            return False
