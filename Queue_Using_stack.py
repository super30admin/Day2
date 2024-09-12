# // Time Complexity : push: O(1), pop: amortized O(1) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class MyQueue:

    # initialize two stacks
    def __init__(self):
        self.s1 = []
        self.s2 = []

    # append the value to s1
    def push(self, x):
        self.s1.append(x)

    # pop from s2
    def pop(self):
        self.peek()
        return self.s2.pop()

    # use the popped element from s1 to append s2 
    def peek(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]        

    def empty(self):
        return not self.s1 and not self.s2