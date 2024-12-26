class MyQueue:

    # Brute force approach I used was taking TC for pop and peek as O(n)

    # def __init__(self):
    #     self.primaryStack = []
    #     self.secondaryStack = []
        

    # def push(self, x: int) -> None:
    #     self.primaryStack.append(x)
        

    # def pop(self) -> int:
    #     while len(self.primaryStack)!=0:
    #         self.secondaryStack.append(self.primaryStack.pop())
    #     popped = self.secondaryStack.pop()

    #     while len(self.secondaryStack)!=0:
    #         self.primaryStack.append(self.secondaryStack.pop())  
    #     return popped      
        

    # def peek(self) -> int:
    #     while len(self.primaryStack)!=0:
    #         self.secondaryStack.append(self.primaryStack.pop())
    #     top = self.secondaryStack[-1]

    #     while len(self.secondaryStack)!=0:
    #         self.primaryStack.append(self.secondaryStack.pop()) 
    #     return top    
        

    # def empty(self) -> bool:
    #     return len(self.primaryStack) == 0 and len(self.secondaryStack) == 0

# Approach Discussed in class

    def __init__(self):
        self.primaryStack = []
        self.secondaryStack = []
        

    def push(self, x: int) -> None:
        self.primaryStack.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.secondaryStack.pop()           
        

    def peek(self) -> int:
        if len(self.secondaryStack) == 0:
            while len(self.primaryStack)!=0:
                self.secondaryStack.append(self.primaryStack.pop())
        return self.secondaryStack[-1]        
           
    def empty(self) -> bool:
        return len(self.primaryStack) == 0 and len(self.secondaryStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
