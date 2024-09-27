# Time Complexity : O(1) for push and O(n) worst
#  case for pop but 0(1) generally
# Space Complexity : 0(n) 2 stacks defined 
# to make things work
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:
    # Initialize the queue
    def __init__(self):
        self.inStack = []
        self.outStack = []
        
    # Push operation is simple 
    # Push the elements in inStack
    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    # Pop elements is not all that simple
    # pop elements directly from OutStack
    # if outStack is not empty
    # else transfer all elements from inStack
    # to outStack

    def pop(self) -> int:
        if len(self.outStack) == 0:
            while(len(self.inStack)!=0):
                self.outStack.append(self.inStack.pop())
        
        return self.outStack.pop()

    # Peek is same as pop            
    def peek(self) -> int:
        if len(self.outStack) == 0:
            while(len(self.inStack)!=0):
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        
    # Chack if the queue is empty which happens
    # only when both stacks are empty
    def empty(self) -> bool:
        if ((len(self.inStack) + len(self.outStack)) == 0):
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()