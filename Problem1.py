# Time Complexity :  O(n)
# Space Complexity : O(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

#    Yes, my main programming lang is python so instruction was not clear

# Your code here along with comments explaining your approach
class MyQueue:
# using 2 stack
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        # move all s1 into s2
        while self.s1:
            top = self.s1.pop()
            self.s2.append(top)
            
        self.s1.append(x)
        # move all from s2 back to s1
        while self.s2:
            top = self.s2.pop()
            self.s1.append(top)

    def pop(self) -> int:
        return self.s1.pop()

    def peek(self) -> int:
        if len(self.s2) == 0:
            while(len(self.s2)!=0):
                
        return self.s1[-1]

    def empty(self) -> bool:
        return len(self.s1) == 0