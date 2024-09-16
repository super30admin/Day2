class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.front = None

    def push(self, x: int) -> None:
        if len(self.stack1) == 0:
            self.front = x
        self.stack1.append(x)
        

    def pop(self) -> int:
        if len(self.stack2) == 0:
            while (len(self.stack1) !=0):
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()
        

    def peek(self) -> int:
        if len(self.stack2) != 0:
            return self.stack2[-1]
        return self.front

    def empty(self) -> bool:
        return   (len(self.stack1) == 0 and len(self.stack2) == 0) 
        

# Your MyQueue object will be instantiated and called as such:
#obj = MyQueue()
#obj.push(1)
#obj.push(2)
#param_3 = obj.peek()
#print(param_3)
#param_2 = obj.pop()
#print(param_2)
#param_4 = obj.empty()
#print(param_4)