# Design-2

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

#Approach
# Create instack & outstack(list). Everytime for the push operation, push the element in the instack list
# For pop & peek operation, first pop all elelments from instack to outstack and while it is not empty, return element from outstack everytime


# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)
        print('instack',self.instack)

    def pop(self) -> int:
        if len(self.outstack) == 0:
            while self.instack:
                x = self.instack.pop()
                self.outstack.append(x)
        return self.outstack.pop()


    def peek(self) -> int:
        if len(self.outstack) == 0:
            while self.instack:
                x = self.instack.pop()
                self.outstack.append(x)
        print('outstack',self.outstack)
        return self.outstack[-1]

    def empty(self) -> bool:
        if len(self.instack) == 0 and len(self.outstack) == 0:
            return True
        return False