class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        self.peek()
        return self.s2.pop()


    def peek(self) -> int:
        if  len(self.s2) == 0 :
            while (len(self.s1) != 0):
                self.s2.append(self.s1.pop())
        curr = self.s2.pop()
        self.s2.append(curr)
        return curr

    def empty(self) -> bool:
        
            return len(self.s1) == 0 and len(self.s2) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()