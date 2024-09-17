# Time Complexity : O(1) - Amortized
# Space Complexity : O(n), Theta(2n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
I used to 2 stack one for pushing and for popping. for pop operation if the second stack is empty, transfer the content
of stack1 by popping them out, then finally pop from the second stack

Initially I started with two stack but with two different top pointers corresponding to the two stacks used.
For stack 1 top was pointing to the top element, for the second stack top was pointing to bottom element, and the element
were pushed and popped together from both the stacks, but that had more space complexity
'''

from collections import deque
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.stack_in = deque()
        self.stack_out = deque()
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack_in.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # if not self.stack_out:
        #     while self.stack_in:
        #         self.stack_out.append(self.stack_in.pop())
                
        # print(self.stack_out)
        
        _ = self.peek()
        
        return self.stack_out.pop()
                
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        
        return self.stack_out[-1]
        
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.stack_in or self.stack_out:
            return False
        else:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()