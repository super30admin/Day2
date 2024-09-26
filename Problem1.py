class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        try:
            out = self.stack2.pop()
        except:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            out = self.stack2.pop()                
        return out



    def peek(self) -> int:
        """
        Get the front element.
        """
        try:
            return self.stack2[-1]
        except:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.stack1 or self.stack2:
            return False
        else:
            return True
