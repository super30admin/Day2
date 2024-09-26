## Time Complexity: O(1) average for all cases. Push always O(1)
## Space Complexity: O(n)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []
    

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)
        
    def transferStack(self,inStack,outStack):
        
        return [], inStack[::-1]
    
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.empty():
            return None
        if len(self.outStack) == 0:
            self.inStack, self.outStack = self.transferStack(self.inStack, self.outStack)
        
        
        return self.outStack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.empty():
            return None
        if len(self.outStack) == 0:
            self.inStack, self.outStack = self.transferStack(self.inStack, self.outStack)
        #print(self.outStack)
        return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.inStack) + len(self.outStack) == 0:
            return True
        return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
