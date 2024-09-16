# Time Complexity : O(N) for Push and O(1) for pop
# Space Complexity : O(N) for Push and O(1) for pop
# Did this code successfully run on Leetcode : Yes with Runtime: 16 ms and Memory Usage: 13.5 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : Two Stacks are implemented using
# List. The elements of stack1 are inserted to stack2 and than new element is inserted on stack2
# than all elements from stack2 are inserted to stack1. The elements are then popped and top is
# returned.

class MyQueue(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]
        self.stack2=[]

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # Push item into stack2
        while len(self.stack1) != 0:  
            self.stack2.append(self.stack1.pop())  
        self.stack2.append(x)  
  
        # Push everything back to stack1  
        while (len(self.stack2) != 0):  
            self.stack1.append(self.stack2.pop())       

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        return self.stack1.pop() 

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        x= self.stack1[-1]
        return x 

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.stack1
            
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()