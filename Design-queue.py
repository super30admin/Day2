# Time Complexity : o(N)
# Space Complexity : o(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyQueue(object):

    def __init__(self):
        self.stack = []
        self.shuffle_stack = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        while self.stack:
            self.shuffle_stack.append(self.stack.pop())
            
        self.stack.append(x)
        
        while self.shuffle_stack:
            self.stack.append(self.shuffle_stack.pop())
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        return self.stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        return self.stack[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.stack) == 0

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()

print(param_2)
print(param_3)
print(param_4)