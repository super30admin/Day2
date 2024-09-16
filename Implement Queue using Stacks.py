class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inq = []
        self.outq = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inq.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.outq)==0:
            while len(self.inq)!=0:
                self.outq.append(self.inq.pop())
        return self.outq.pop()        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outq)==0:
            while len(self.inq)!=0:
                self.outq.append(self.inq.pop())
        return self.outq[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not len(self.inq) and not len(self.outq)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
