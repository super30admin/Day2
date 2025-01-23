'''
// Time Complexity :
push : O(1)
pop : O(n)
peek : O(n)
empty : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

'''

class MyQueue(object):

    def __init__(self):
        self.stack_in=[]
        self.stack_out=[]
        

    def _move(self):
        """
        Move elements from stack_in to stack_out if stack_out is empty.
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack_in.append(x)

        

    def pop(self):
        """
        :rtype: int
        """
        self._move()
        return self.stack_out.pop() if self.stack_out else None
        
        

    def peek(self):
        """
        :rtype: int
        """
        self._move()
        return self.stack_out[-1] if self.stack_out else None
        
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.stack_in and not self.stack_out

        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()