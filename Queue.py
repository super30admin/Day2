class MyQueue:

    def __init__(self):
        self.stack_1 = []
        self.stack_2 = []
               

    def push(self, x: int) -> None:
        self.stack_1.append(x)
       

    def pop(self) -> int:
        if len(self.stack_2) == 0:
            while len(self.stack_1) != 0:
                self.stack_2.append(self.stack_1.pop())
        return self.stack_2.pop()
       

    def peek(self) -> int:
        if len(self.stack_2) == 0:
            while len(self.stack_1) !=0:
                self.stack_2.append(self.stack_1.pop())
        return self.stack_2[-1]
      
        
       
        
        
    def empty(self) -> bool:
        return len(self.stack_1) == 0 and len(self.stack_2) == 0
        
        
        
            
            
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()