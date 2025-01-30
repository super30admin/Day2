class MinStack:

    def __init__(self):
        self.min = int(sys.maxsize)
        self.m=[]
        self.s=[]
        self.m.append(self.min)


    def push(self, val: int) -> None:
        if val< self.min:
            self.min=val
        self.m.append(self.min)
        self.s.append(val)

    def pop(self) -> None:
        self.s.pop()
        self.m.pop()
        self.min=self.m[-1]

    def top(self) -> int:
        return self.s[-1]        

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()