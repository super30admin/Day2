class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]
        self.stack2=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack1)==0:
            return None
        x=len(self.stack1)
        while(x>0):
            x-=1
            self.stack2.append(self.stack1.pop())
        final=self.stack2.pop()#pop the last element in stack2 which will be first element if stack1
        while(len(self.stack2)>0):
            self.stack1.append(self.stack2.pop())
        return final

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack1)==0:
            return None
        x=len(self.stack1)
        while(x>0):
            x-=1
            self.stack2.append(self.stack1.pop())
        final=self.stack2[-1]#show the last element in stack2 which will be first element if stack1
        while(len(self.stack2)>0):
            self.stack1.append(self.stack2.pop())
        return final

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack1)==0:
            return True
        return False
