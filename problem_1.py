# Time Complexity: O(1) for push, O(n) for pop and peek, O(1) for empty
# Space Complexity: O(n) for push, O(1) for pop, peek and empty
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# https://leetcode.com/problems/implement-queue-using-stacks/ 

# Approach:
# Use two stacks to implement queue. In_stack is used to push elements 
# and out_stack is used to pop elements.
# If out_stack is empty, pop all elements from in_stack and push to out_stack.
# Pop elements from out_stack.
# Peek elements from out_stack.
# Check if both stacks are empty to check if queue is empty.


class MyQueue:

    def __init__(self):
        self.in_stack  = []
        self.out =[]

    def push(self, x: int) -> None:
        self.in_stack.append(x)


    def pop(self) -> int:
        self.peek()
        return self.out.pop()

    def peek(self) -> int:
        if not self.out:
            while self.in_stack:
                self.out.append(self.in_stack.pop())
        return self.out[-1]

    def empty(self) -> bool:
        return not self.out and not self.in_stack