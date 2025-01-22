# Time Complexity : 
    # push() -> O(1)
    # pop() -> amortized O(1) [O(N) in the worst case when stack2 is empty and elements are transferred from stack1 to stack2]
    # peek() -> O(1)
    # empty() -> O(1)

# Space Complexity : O(N)

# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach
# 2 stacks, 1 for pushing elements and the other for popping

class MyQueue:

    def __init__(self):
        self.stack1 = [] # push stack
        self.stack2 = [] # pop stack

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        # if stack2 is not empty, pop directly
        if len(self.stack2) > 0:
            return self.stack2.pop()
        
        # invert the order of items in stack1 by transferring them to stack2 to maintain FIFO
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        
        return self.stack2.pop()

    def peek(self) -> int:
        if len(self.stack2) > 0:
            return self.stack2[-1]
        
        return self.stack1[0]

    def empty(self) -> bool:
        return len(self.stack1) + len(self.stack2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()