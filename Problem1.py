# // Time Complexity :   O(1)
# // Space Complexity :  S(1)
# // Did this code successfully run on Leetcode :   Yes
# // Any problem you faced while coding this :    Nope


# // Your code here along with comments explaining your approach

from collections import deque

class MyQueue(object):

    def __init__(self):
        self.deq = deque([])

    def push(self, x):
        self.deq.append(x)
        

    def pop(self):
        return self.deq.popleft()
        """
        :rtype: int
        """

    def peek(self):
        return self.deq[0]
        """
        :rtype: int
        """
        
    def empty(self):
        return True if len(self.deq)==0 else False
        """
        :rtype: bool
        """


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()