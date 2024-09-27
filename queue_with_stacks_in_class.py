# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        self.stack1.append(x)

    def pop(self):
        if len(self.stack2) > 0:
            return self.stack2.pop()
        else:
            while(len(self.stack1)) > 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()

    def peek(self):
        if len(self.stack2) > 0:
            return self.stack2[-1]
        else:
            while(len(self.stack1)) > 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self):
        return len(self.stack1) == 0 and len(self.stack2) == 0