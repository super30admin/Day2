#Time Complexity: O(1) for push, O(1) for avg pop case and worst case O(n), O(1) for peek
#space complexity: O(n) creates an addl. stack of size n 
class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
        
    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        if not self.outStack:  
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) > 0:
            return self.outStack[-1]
        return self.inStack[0]       

    def empty(self) -> bool:
        if not self.inStack and not self.outStack:
            return True
        return False