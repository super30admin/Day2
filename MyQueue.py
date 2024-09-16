"""
// Time Complexity : O(1) for push(), empty is O(1 ), pop O(n)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue 
should support all the functions of a normal queue (push, peek, pop, and empty).

// Your code here along with comments explaining your approach
-a stack is LIFO
"""

class MyQueue:

    def __init__(self):
        self.inside = []
        self.out = []

    def push(self, x: int) -> None:
        self.inside.append(x)

    def pop(self) -> int:
        self.reverse()
        if self.empty():
            print("Queue is empty")
        if len(self.out) >0:
             return self.out.pop()

    def peek(self) -> int:
        self.reverse()
        if len(self.out) >0:
            return self.out[-1]

    def empty(self) -> bool:
        if self.out == self.inside:
            return True;
        return False
        
    def reverse(self):
        if not self.out :
            while self.inside:
                self.out.append(self.inside.pop())


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()