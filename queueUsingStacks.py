# Time Complexity : O(1) for push,empty and amortized O(1) for pop,peek
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if self.empty() is False:
            if len(self.stack2) == 0:
                self.transferFromStack1ToStack2()
            return self.stack2.pop()

    def peek(self) -> int:
        if self.empty() is False:
            if len(self.stack2) == 0:
                self.transferFromStack1ToStack2()
            return self.stack2[-1]

    def empty(self) -> bool:
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return True
        return False
    
    def transferFromStack1ToStack2(self):
        for i in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())