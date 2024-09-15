class MyQueue:

    def __init__(self):
        self.stackpush=[]
        self.stackpop=[]
        self.top=None
        

    def push(self, x: int) -> None:
        if not self.stackpush:
            self.top=x
        self.stackpush.append(x)

    def pop(self) -> int:
        if not self.stackpop:
            while self.stackpush:
                self.stackpop.append(self.stackpush.pop())
        return self.stackpop.pop()

    def peek(self) -> int:
        if self.stackpop:
            return self.stackpop[-1]
        return self.top

    def empty(self) -> bool:
        return not self.stackpush and not self.stackpop


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()