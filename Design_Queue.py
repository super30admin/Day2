class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #implementing the solution using two stack method
        self.pushStack = []
        self.popStack = []
        
        
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.popStack) == 0:
            
            while len(self.pushStack) > 0:
                
                self.popStack.append(self.pushStack.pop())
        
        return self.popStack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.popStack) == 0:
            
            while len(self.pushStack) > 0:
                
                self.popStack.append(self.pushStack.pop())
        
        if len(self.popStack ) > 0 :    
            
            return self.popStack[-1]
        
        return -1
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        
        if len(self.pushStack) == 0 and len(self.popStack) == 0 :
            
            return True
        
        return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
