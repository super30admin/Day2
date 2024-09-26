# Queue using stack

class MyQueue:

    def __init__(self):
        
        self.inStack = []
        self.outStack = []
        
    def push(self, x: int) -> None: #O(1)
        self.inStack.append(x)
    
    def transfer(self, in_stack, out_stack): # O(n)
        while len(in_stack) != 0:
            out_stack.append(in_stack.pop())
        

    def pop(self) -> int: # O(1)
        if (len(self.outStack) == 0):
            # there will be a check here if we cannot have empty stack to check for null pointer exception
            self.transfer(self.inStack, self.outStack)
            
        return self.outStack.pop()

    def peek(self) -> int: # O(1)
        if (len(self.outStack) == 0):
            # there will be a check here if we cannot have empty stack to check for null pointer exception
            self.transfer(self.inStack, self.outStack)
            
        return self.outStack[-1]
        

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0
        

# Space complexity is O(n)
# Average case for time is O(1)
