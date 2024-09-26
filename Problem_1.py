# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : Figuring out the way to make it work in amortized O(1)

class MyQueue(object):

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.front = None

    #taking care of the front when second stack is empty
    def push(self, x):
        if not self.stack1:
            self.front = x
        self.stack1.append(x)

    def pop(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        ans = self.stack2.pop()
        return ans

    def peek(self):
        if self.stack2:
            return self.stack2[-1]
        
        return self.front

    def empty(self):
        return (not self.stack1 and not self.stack2)