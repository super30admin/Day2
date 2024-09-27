# Implement the following operations of a queue using stacks.

class MyQueue:
    # 1. With One Stack
    # Time = Push O(n) per operation, Pop - O(n) per operation 
    # Space = Push O(n) per operation, Pop - O(n) per operation
    """ def __init__(self):        
        self.stack = []
        
    def push(self, x: int) -> None:       
        self.stack.append(x)
        print(self.stack)

    def pop(self) -> int:        
        return self.stack.pop(0)

    def peek(self) -> int:       
        if len(self.stack) == 0:
            return None
        else:
            print("here",self.stack)
            return self.stack[0]

    def empty(self) -> bool:
        if len(self.stack) == 0:
            return True
        else:
            return False"""
        
        
    # 2. Using two stacks - one to do push operation(writeStack;  second to pop,peek operation(readStack)  
    # Time = Push - O(1) per operation, Pop - Amortized O(1) per operation
    # Space = Push - O(1) per operation, Pop - Amortized O(1) per operation
    def __init__(self):
        self.writeStack = []
        self.readStack = []
        
    def push(self, x):
        self.writeStack.append(x)

    def pop(self):
        if(self.readStack == []):
            while(self.writeStack != []):
                self.readStack.append(self.writeStack.pop())
        return self.readStack.pop()
        
    def peek(self):
        if(self.readStack == []):
            while(self.writeStack != []):
                self.readStack.append(self.writeStack.pop())
        return self.readStack[-1]
        
    def empty(self):
        return self.writeStack == [] and self.readStack == []