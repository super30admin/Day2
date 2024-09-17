class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        while self.s1:
            self.s2.append(self.s1.pop())
        p = self.s2.pop()
        while self.s2:
            self.s1.append(self.s2.pop())
        return p
        

    def peek(self) -> int:
        while self.s1:
            self.s2.append(self.s1.pop())
        p = self.s2[len(self.s2) - 1]
        while self.s2:
            self.s1.append(self.s2.pop())
        return p
        
    def empty(self) -> bool:
        return self.s1 == [ ]
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()