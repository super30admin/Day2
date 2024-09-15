

#Time complexity : ush: O(1), pop: O(n),peek:O(n), empty: O(1)
#Space complexity: O(n) 

# Implemented queue using two stacks.
# In push function, the element is appended in to input stack.
# In pop function, We pop element from output stack , if it is non empty, and else we pop out the
#elements from input to output, and then pop the top most element form output stack.
# In empty function, we return true if both the stacks are non empty else we return false.

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input=[]
        self.output=[]

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.input.append(x)
        
            
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        
        if len(self.output)!=0:
            
             return self.output.pop()
        else:
            while(len(self.input)!=0):
                self.output.append(self.input.pop())
        return self.output.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.output)==0:
         
            while (len(self.input)!=0):
                self.output.append(self.input.pop())
        return self.output[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.input and (not self.output))


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
