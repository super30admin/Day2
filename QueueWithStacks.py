# Time Complexity :O(1)
# Space Complexity :O(n); n is size of the in and out stacks
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
'''
For push operation, data is directly pushed to in stack
For pop and peek, if out stack is empty then push all the elements from in stack to out stack and return the top of out stack
For empty, check if the length of the stack is zero
'''
from collections import deque
class MyQueue:

    def __init__(self):
        self.out = deque()
        self.ins = deque()
        

    def push(self, x: int) -> None:
        self.ins.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.out.pop()
        
        

    def peek(self) -> int:
        if len(self.out) == 0:
            while len(self.ins) != 0:
                self.out.append(self.ins.pop())
        return self.out[-1]
        

    def empty(self) -> bool:
        return len(self.ins) == 0 and len(self.out) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
