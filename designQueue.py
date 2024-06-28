class MyQueue:

    def __init__(self):
        self.inStack = [] # Stack to handle incoming elements
        self.outStack = [] # Stack to handle outgoing elements
        
    def push(self, x: int) -> None:
        # Push element x to the back of queue
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        # Pop the top element from outStack which is the front element of the queue
        return self.outStack.pop()
        
    # Get the front element of the queue    
    def peek(self) -> int:
        if not self.outStack: 
            # Transfer all elements from inStack to outStack if outStack is empty
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        # Peek the top element from outStack which is the front element of the queue
        return self.outStack[-1]

    def empty(self) -> bool:
        # Return true if both inStack and outStack are empty, otherwise false
        if not self.inStack and not self.outStack: #if len(self.inStack)==0 and len(self.outStack)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
