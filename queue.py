# Time Complexity : O(1) Amortized complexity is O(1), for pop and peek we do move elements but that is rare as comparared to O(1) time required for all the following pop and peek
# Space Complexity : O(N) / size of stack, based on the number of elements added.

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
        

    def push(self, x: int) -> None:
        self.inStack.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
        return not bool(self.inStack) and not bool(self.outStack)
        


obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
print(param_2,param_3,param_4)