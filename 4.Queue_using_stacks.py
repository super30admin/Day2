class MyQueue:

    def __init__(self):
        self.inqueue = []
        self.outqueue = []
    

    def push(self, x: int) -> None:
        self.inqueue.append(x)  

    def pop(self) -> int:
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue.pop()

    def peek(self) -> int:
        if self.outqueue:
            return self.outqueue[len(self.outqueue)-1]
        elif self.inqueue:
            return self.inqueue[0]
        else: return 
            

    def empty(self) -> bool:
        if len(self.inqueue) == 0 and len(self.outqueue) == 0:
            return True
        else: return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()