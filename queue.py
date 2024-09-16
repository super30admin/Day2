#Time complexity for all the operations is O(1)
class MyQueue(object):

    def __init__(self):
        self.inStack = []
        self.outStack = []
        
        

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
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if not self.outStack and not self.inStack:
            return True
        else:
            return False
