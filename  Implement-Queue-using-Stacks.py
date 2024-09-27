#Reference video: https://www.youtube.com/watch?v=jKGkphPsnSI&t=225s
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
        #if elements exist in stack2, pop those
        if self.stack2:
            return self.stack2.pop()
        #if no elements exist in stack2, transfer stack1 to stack2 and then pop from stack2
        else:
            while len(self.stack1)>0:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()
        
            

    def peek(self) -> int:
        
        """
        Get the front element.
        """
        #if elements exist in stack2, peek those
        if self.stack2:
            return self.stack2[-1]
         #if no elements exist in stack2, transfer stack1 to stack2 and then peek
        else:
            while len(self.stack1)>0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

        
            
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        #check if both the stacks are empty
        return self.stack1 == [] and self.stack2 == []
        
            


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()