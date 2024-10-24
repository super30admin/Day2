class MinStack:

    def __init__(self):
        self.s = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.s.append(val)
        min_val = min(val, self.minstack[-1] if self.minstack else val)
        self.minstack.append(min_val)

    def pop(self) -> None:
        self.s.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.minstack[-1]