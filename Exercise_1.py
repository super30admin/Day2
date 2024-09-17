class MyQueue(object):

    # Implement Queue using Stacks

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    def __init__(self):
        self.queue = []

    # Add item to the last
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.queue.append(x)

    # Remove item from first 
    def pop(self):
        """
        :rtype: int
        """
        first_value = self.peek()
        if len(self.queue) == 1:
            self.queue = []
        else:
            self.queue = self.queue[1:]
        return first_value
        
        
        
    # return the first element 
    def peek(self):
        """
        :rtype: int
        """
        return self.queue[0]
        
    # Check if queue empty
    def empty(self):
        """
        :rtype: bool
        """
        return len(self.queue) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()