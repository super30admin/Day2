class Stack():
    def __init__(self):
        self.s = []
    
    def push(self, x: int) -> None:
        self.s.append(x)
    
    def pop(self) -> int:
        
        if self.s != []:
            return self.s.pop()
        return None
        
    def peek(self) -> int:
        
        if self.s != []:
            return self.s[-1]
        return None
    
    def empty(self) -> bool:
        return self.s == []
    
    def size(self):
        return 0 if not self.s else len(self.s)
    
    

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = Stack()
        self.stack2 = Stack()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.push(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.stack2.size() == 0:
            
            while self.stack1.size() != 0:
                self.stack2.push(self.stack1.pop())
        return self.stack2.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.stack2.size() == 0:
            while self.stack1.size() != 0:
                self.stack2.push(self.stack1.pop())
        return self.stack2.peek()

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return  self.stack1.size() == 0 and self.stack2.size() == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
