from collections import deque
#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack=deque()
        self.outStack=deque()

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.inStack.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if(len(self.outStack)==0):
            while(len(self.inStack)!=0):
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if(len(self.outStack)==0):
            while(len(self.inStack)!=0):
                self.outStack.append(self.inStack.pop())
        return self.outStack[len(self.outStack)-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if(len(self.inStack)==0 and len(self.outStack)==0):
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()