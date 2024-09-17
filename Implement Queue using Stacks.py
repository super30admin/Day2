class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = []
        self.pushAndPopStack = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.pushStack.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if self.empty():
            return
        
        if not self.pushAndPopStack:
            while self.pushStack:
                self.pushAndPopStack.append(self.pushStack.pop())
                
        return self.pushAndPopStack.pop()
            

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.empty():
            return
        if not self.pushAndPopStack:
            while self.pushStack:
                self.pushAndPopStack.append(self.pushStack.pop())
                
        return self.pushAndPopStack[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.pushStack and not self.pushAndPopStack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
