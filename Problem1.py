class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.append(x)
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        top = self.s1[0]
        
        self.s1 = self.s1[1:]
        return top
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.s1[0]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.s1)==0