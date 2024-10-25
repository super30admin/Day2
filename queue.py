class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if len(self.outstack) == 0:
            while len(self.instack) > 0:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop() if self.outstack else None

    def peek(self) -> int:
        if len(self.outstack) == 0:
            while len(self.instack) > 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1] if self.outstack else None

    def empty(self) -> bool:
        return len(self.outstack) == 0 and len(self.instack) == 0
