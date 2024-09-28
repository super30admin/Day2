class MyQueue:

    def __init__(self):
        self.input=[]
        self.output=[]
        

    def push(self, x: int) -> None:
        self.input.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.output.pop()
        
        

    def peek(self) -> int:
        if self.output==[]:
            while self.input!=[]:
                self.output.append(self.input.pop())
        if(self.output!=[]):
            return self.output[len(self.output)-1]
            
        

    def empty(self) -> bool:
        return self.input==[] and self.output==[]