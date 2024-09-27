class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stackin=[]
        self.stackout=[]

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.stackin.append(x)        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.stackout)!=0:
            return self.stackout.pop()
        else:
            while len(self.stackin)!=0:
                self.stackout.append(self.stackin.pop())
            return self.stackout.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.stackout)!=0:
            return self.stackout[-1]
        else:
            while len(self.stackin)!=0:
                self.stackout.append(self.stackin.pop())
            return self.stackout[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if len(self.stackin)==0 and len(self.stackout)==0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()