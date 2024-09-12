class MyQueue(object):
    
    def __init__(self):
        self.queue = []
        self.queue1 = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.queue.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if not self.queue1:
            while self.queue:
                self.queue1.append(self.queue.pop())
        return self.queue1.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.queue1:
            while self.queue:
                self.queue1.append(self.queue.pop())
        return self.queue1[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return self.queue == [] and self.queue1 == []
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()