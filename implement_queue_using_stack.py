# Time Complexity: Amortized O(1), Worst: O(n)
# Space Complexity: O(n)

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
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.outStack) == 0:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outStack) == 0:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
                
        return self.outStack[-1]
        
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.inStack)==0 and len(self.outStack)==0:
            return True
        else:
            return False       


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()