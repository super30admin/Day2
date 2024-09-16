# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes it did.
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        # initializing two stacks
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        # appending to stack 1
        self.s1.append(x)

    def pop(self) -> int:
        # if stack 2 is full, pop the top element
        if self.s2:
            return self.s2.pop()
        # else, pop everything from stack 1 and push to stack 2
        else:
            while self.s1:
                self.s2.append(self.s1.pop())
            # then return the topmost element
            return self.s2.pop()

    def peek(self) -> int:
        # if stack 2 is full, return the top element
        if self.s2:
            return self.s2[-1]
        # else, pop everything from stack 1 and push to stack 2
        else:
            while self.s1:
                self.s2.append(self.s1.pop())
            # then return the topmost element
            return self.s2[-1]

    def empty(self) -> bool:
        # return false for any non-empty stack
        if self.s1:
            return False
        elif self.s2:
            return False
        return True

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
