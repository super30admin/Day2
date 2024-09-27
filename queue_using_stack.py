class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.ind = []
        self.out = []
        
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.ind.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.out :
            while self.ind:
                self.out.append(self.ind.pop())
        return self.out.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.out :
            while self.ind:
                self.out.append(self.ind.pop())
        return self.out[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.ind and not self.out)  
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()