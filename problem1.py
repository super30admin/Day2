from collections import deque

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #self.lst=[]   
        self.stack1=deque()                                                         #Initialized both the stacks
        self.stack2=deque()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)                                                               # Time Complexity : O(1)
        
    
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """                                                                           # Time Complexity : Amortized O(1)
        if not self.stack2:                                                           #if stack2 is not empty then pop the element from stack2 otherwise pop all the elements from stack1 and push them into stack2 then pop the element from stack2
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """                                                                            # Time Complexity : Amortized O(1)
        if not self.stack2:                                                             # #if stack2 is not empty then get the top element from stack2 otherwise pop all the elements from stack1 and push them into stack2 then get the top element from stack2
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        

    def empty(self) -> bool:                                      
        """
        Returns whether the queue is empty.
        """                                                                        #check if both the stacks are empty then return true ottherwise false
        return False if (self.stack1 or self.stack2)else True                      # Time Complexity : Amortized O(1)
          


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


# Did this code successfully run on Leetcode : yes
