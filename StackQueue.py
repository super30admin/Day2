# Time Complexity : Averages to O(1) for Each Function
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue: 
    ''' Always push to inStack
        Always pop from outStack (if the outStack is empty then move things over to outStack)  
    '''
    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        if not self.outStack:
            self.peek()
        
        poppedEle = self.outStack.pop()
        return poppedEle
        

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack[-1]
        

    def empty(self) -> bool:
        return ((not self.inStack) and (not self.outStack))