# // Time Complexity : O(n) for Pop , O(1) for push)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class MyQueue:

    def __init__(self):
        self.instack=[]
        self.outstack=[]

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()

    def peek(self) -> int:
        if len(self.outstack)==0:
            while len(self.instack):
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        return len(self.outstack)==0 and len(self.instack)==0

