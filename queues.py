class MyQueue(object):

    def __init__(self):
        self.queue = []
        """
        Initialize your data structure here.
        """
        

    def push(self, x):
        self.queue.append(x)
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        

    def pop(self):
        temp = []
        while self.queue:
            temp.append(self.queue.pop())
        pop = temp.pop()
        while temp:
            self.queue.append(temp.pop())
        return pop
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        

    def peek(self):
        temp = []
        while self.queue:
            temp.append(self.queue.pop())
        pop = temp[-1]
        while temp:
            self.queue.append(temp.pop())
        return pop
        
        """
        Get the front element.
        :rtype: int
        """
        

    def empty(self):
        return len(self.queue) == 0
        """
        Returns whether the queue is empty.
        :rtype: bool
        """