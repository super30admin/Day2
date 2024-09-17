class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = [float('inf')]

        

    def push(self, val: int) -> None:
         
        self.stack.append(val)
        self.minStack.append(min(self.minStack[-1],val))
        
        

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]