class MyQueue:

    def __init__(self):
        
        self.stack1 = []
        self.stack2 = []             #space complexity --- o(n)
        

    def push(self, x: int) -> None:        
        self.stack1.append(x)    #time complexity - o(1)
        
    def pop(self) -> int:
                
        while len(self.stack1)!=1:
            self.stack2.append(self.stack1.pop())
        
        res = self.stack1.pop()
        
        while len(self.stack2)!=0:
            self.stack1.append(self.stack2.pop())
        
        return res                                      #worst case time complexity ---- o(n)
                                                        # amortized tc -- o(1)
    
    
           
        

    def peek(self) -> int:
        
        while len(self.stack1)!=1:
            self.stack2.append(self.stack1.pop())
        
        res = self.stack1[0]
        
        while len(self.stack2)!=0:
            self.stack1.append(self.stack2.pop())
        
        return res                    #worst case time complexity ---- o(n)
                                      # amortized tc -- o(1)
    
        

    def empty(self) -> bool:
        
        if len(self.stack1)==0 and len(self.stack2)==0:
            return True
        else:
            return False                       #tc o(1)
