class MyQueue:

    def __init__(self):
        self.push_stack =[]
        self.pop_stack = []
    def push(self, x: int) -> None:
        self.push_stack.append(x)

    def pop(self) -> int:
        
        if not self.pop_stack:
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
        #rint(self.pop_stack)
        pop_ele =self.pop_stack.pop()
        return pop_ele
        
        

    def peek(self) -> int:
        if self.pop_stack:
            return self.pop_stack[-1]
        else:
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
            return self.pop_stack[-1]           
            

    def empty(self) -> bool:
        
        if not self.pop_stack:
            
            if not self.push_stack:
                
                return True
        else:
            return False