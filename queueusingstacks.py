class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Create two Stacks
        self.stack1=[]
        self.stack2=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        while self.stack2:
            self.stack1.append(self.stack2.pop())
            
        self.stack1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #Transfer Elements from Stack1 to Stack2
        #Return Element of Stack2-Pop
        
        for i in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())
            
        return self.stack2.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        #Transfer Elements from Stack1 to Stack2 #Same logic which is used in pop
        #Return Element of Stack2-Peek
        
        for i in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())
            
        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.stack1==[] and self.stack2==[]


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()