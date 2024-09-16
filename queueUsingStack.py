# Time Complexity : o(1) All Operations
# Space Complexity : o(1) No extra space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue(object):
    def __init__(self):
        self.inqueue = []
        self.outqueue = []
    def push(self, x):
        self.inqueue.append(x)
    def pop(self):
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue.pop()
    def peek(self):
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue[-1]        
    def empty(self):
        return not self.inqueue and not self.outqueue