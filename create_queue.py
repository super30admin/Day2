class MyQueue(object):

    def __init__(self):
        self.mystack1 = []
        self.mystack2 = []
        
        """
        Initialize your data structure here.
        """
        

    def push(self, x):
        self.mystack1.append(x)
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        

    def pop(self):
        if len(self.mystack2) == 0:
            while(len(self.mystack1) != 0):
                temp = self.mystack1.pop()
                self.mystack2.append(temp)
        return self.mystack2.pop()
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        

    def peek(self):
        if len(self.mystack2) == 0:
            while(len(self.mystack1) != 0):
                temp = self.mystack1.pop()
                self.mystack2.append(temp)
        return self.mystack2[-1]
        """
        Get the front element.
        :rtype: int
        """
        

    def empty(self):
        if len(self.mystack1) == 0 and len(self.mystack2) == 0:
            return True 
        else:
            return False
            
        
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()