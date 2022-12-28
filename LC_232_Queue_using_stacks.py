# Time Complexity: 0(N)
# Space Complexity : 0(2N)



class MyQueue:

    def __init__(self):
        self.inStack= []
        self.outStack = []
        

    def push(self, x: int) -> None:
        self.inStack.append(x)
   
    def pop(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack)!=0:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()
        

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack)!=0:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack[-1]
        

    def empty(self) -> bool:
        if (len(self.inStack) or len(self.outStack)) == 0:
            return True
        return False
        
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()