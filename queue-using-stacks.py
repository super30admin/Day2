# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack_1 = []
        self.stack_2 = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.stack_1.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #if there are nodes in stack_2 pop from it directly
        if len(self.stack_2) > 0:
            return self.stack_2.pop()
        else:
        #else fill stack one to have a queue then pop
            while self.stack_1:
                self.stack_2.append(self.stack_1.pop())
            return self.stack_2.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # if there are nodes in stack_2 peek from it directly
        if len(self.stack_2) > 0:
            return self.stack_2[-1]
        else:
        #else fill stack one to have a queue then peek
            while self.stack_1:
                self.stack_2.append(self.stack_1.pop())
            return self.stack_2[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        #check both stacks if both are empty then the queue is empty
        if not self.stack_1 and not self.stack_2:
            return True
        else:
        #else it is not empty
            return False
        