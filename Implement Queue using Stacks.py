class Solution:
    def __init__(self):
        self.stack = []
        self.s2 = []

    def push(self, x):
        self.stack.push(x)

    def pop(self):
        if self.s2:
            element = self.s2.pop()
            return element
        if self.stack:
            while self.stack:
                self.s2.append(self.stack.pop())
            element =self.s2.pop()
            return element
        print("Cannot pop from empty queue.")

    def peek(self):
        if self.s2:
            return self.s2[-1]
        if self.stack:
            while self.stack:
                self.s2.append(self.stack.pop())
            return self.s2[-1]
        print("Cannot peek into an empty queue.")

    def empty(self):
        return (not self.s2) and (not self.stack)

