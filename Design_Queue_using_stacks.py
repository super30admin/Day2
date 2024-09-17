# Time Complexity :amortized - push: O(1), pop: O(1), peek: O(1), empty: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    # We will transfer the elements from stakc1 to stack2
    def transfer(self):
        if len(self.stack2) == 0:
            for i in range(len(self.stack1)):
                self.stack2.append(self.stack1.pop())

    # pushing the elements into the stack1
    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    # we will see if the length of the stack2 is zero, if not, we will pop the top element from stack2.
    def pop(self) -> int:
        self.transfer()
        return self.stack2.pop()
        

    # we will see if the length of the stack2 is zero, if not, we will peek the top element from stack2.
    def peek(self) -> int:
        self.transfer()
        return self.stack2[-1]
        

    # we will return if both the stacks are empty.
    def empty(self) -> bool:
        if len(self.stack1) == 0 and len(self.stack2)==0:
            return True
        return False
        