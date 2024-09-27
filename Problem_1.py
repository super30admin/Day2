class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first_stack=[]
        self.second_stack=[]
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.first_stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        front=self.get_last(is_peek=False)
        return front

    def peek(self) -> int:
        """
        Get the front element.
        """
        front=self.get_last(is_peek=True)
        return front

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.first_stack)==0
    def get_last(self,is_peek):
        while(len(self.first_stack)>1):
            self.second_stack.append(self.first_stack.pop())
            
        front=self.first_stack.pop()
        if(is_peek):
             self.first_stack.append(front)
        while(len(self.second_stack)>0):
            self.first_stack.append(self.second_stack.pop())
        return front

        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()