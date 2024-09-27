class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.myQueue=[]
        
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if(1<=x<=9):
            self.myQueue.append(x)
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        z=self.myQueue.pop(0)
        return z
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        y= self.myQueue[0]
        return y
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if(len(self.myQueue)>0):
            return False
        return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()