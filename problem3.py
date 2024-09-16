class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inele = []
        self.outele = []

    def transfer(self, in_, out_):
        while len(in_) != 0:
            out_.append(in_.pop())
            
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inele.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #transfer
        if len(self.outele) == 0:
            self.transfer(self.inele,self.outele)
        return self.outele.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outele) == 0:
            self.transfer(self.inele,self.outele)
        return self.outele[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.inele)==0 and len(self.outele)==0 
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()