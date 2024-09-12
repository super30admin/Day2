# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack += [x]
        
    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack += [self.inStack.pop()]
        
        return self.outStack[-1]
        
    def empty(self) -> bool:
        return not self.inStack and not self.outStack
        