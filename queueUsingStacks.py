"""Approach: Using two stacks"""
#Accepted on Leetcode
#Time Complexity - O(1) for push and O(N) for pop and peek

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []        
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.push_stack.append(x)        
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.pop_stack) != 0:
            return self.pop_stack.pop()
        else:
            while len(self.push_stack) != 0:
                self.pop_stack.append(self.push_stack.pop())
            return self.pop_stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.pop_stack) != 0:
            return self.pop_stack[-1]
        else:
            while len(self.push_stack) != 0:
                self.pop_stack.append(self.push_stack.pop())
            return self.pop_stack[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if self.push_stack == [] and self.pop_stack == []:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()