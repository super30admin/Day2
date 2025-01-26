
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

'''
used 2 stacks:
an input stack and output stack
maintained a peek element that will hold first element when we push into stack to have a top and this will be 0(1) : Peek operation
'''
class MyQueue:

    def __init__(self):
        self.input_stack=[]
        self.output_stack=[]
        self.peek_element=0

    def push(self, x: int) -> None:
        if len(self.input_stack)==0:
            self.peek_element=x
        self.input_stack.append(x)
        
    def pop(self) -> int:
        '''
        input[] -> output[]
        '''
        if len(self.output_stack)==0:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        return self.output_stack.pop()
    
    def peek(self) -> int:
        if len(self.output_stack)==0:
            return self.peek_element
        else:
            return self.output_stack[-1]

    def empty(self) -> bool:
        if len(self.output_stack)==0 and len(self.input_stack)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()