# Time Complexity : O(1) for push and peek, O(n) if out_stack is empty else O(1)
# Space Complexity : O(n)

"""
This is a 2 stack approach
In_stack is solely for push operations and the Out_stack for pop and peek
We will push all elements into the in_stack as per usual. Before pop(), we
will check if out_stack is empty. If it is then we transfer everything 
from in_stack to out_stack and then pop from out_stack. 
"""
class MyQueue(object):
    in_stack = []
    out_stack = []

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_stack = []
        self.out_stack = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)
    
    def transfer(self, in_stack, out_stack):
        while self.in_stack:
            popped = self.in_stack.pop()
            self.out_stack.append(popped)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if not self.out_stack:
            self.transfer(in_stack = [], out_stack = [])
        return self.out_stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.out_stack:
            self.transfer(self.in_stack, self.out_stack)
        return self.out_stack[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if self.out_stack or self.in_stack:
            return False
        else:
            return True
        