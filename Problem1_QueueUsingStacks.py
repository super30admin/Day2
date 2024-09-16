# Time Complexity: push - O(1), pop and peek - average case - O(1), empty - O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class MyQueue:

    # Initializing two stacks - one to add elements and another to remove elements
    def __init__(self):
        self.instack = []
        self.outstack = []

    # push - Append the element to the instack
    def push(self, x: int) -> None:
        self.instack.append(x)

    # pop - Transfer elements from instack to outstack and pop the top element from outstack
    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()

    # peek - Transfer elements from instack to outstack and return the top element from outstack
    def peek(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())

        return self.outstack[-1]

    # empty - Return true if both stacks are empty
    def empty(self) -> bool:
        return not self.instack and not self.outstack