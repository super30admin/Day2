# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.front = -1
        

    def push(self, x: int) -> None:
        if not self.stack1:
            self.front = x
        self.stack1.append(x)


    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

        res = self.stack2.pop()
        return res

       
    def peek(self) -> int:
        if self.stack2:
            return self.stack2[-1]
        return self.front
        

    def empty(self) -> bool:
        return len(self.stack2) == 0 and len(self.stack1) == 0
        
