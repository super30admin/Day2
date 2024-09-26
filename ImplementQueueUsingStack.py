class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack=[]
        self.popStack=[]
    #Average time is O(1)
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushStack.append(x)
    #O(1)
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(len(self.popStack)==0):
            while(len(self.pushStack)!=0):
                self.popStack.append(self.pushStack.pop())
        return self.popStack.pop()
            
    #O(1)   
    def peek(self) -> int:
        """
        Get the front element.
        """
        if(len(self.popStack)==0):
            while(len(self.pushStack)!=0):
                self.popStack.append(self.pushStack.pop())
        return self.popStack[-1]
    #O(1)        
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.popStack)==0 and len(self.pushStack)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
