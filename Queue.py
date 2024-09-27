// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        """
        Initializing the data structure
        """
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        """
        Pushing element x to the back of queue.
        """
        self.stack1.append(x)
        
            
    def pop(self) -> int:
        """
        Removing the element from in front of queue and returns that element.
        """
        for _ in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())
            
        result = self.stack2.pop()
        
        for _ in range(len(self.stack2)):
            self.stack1.append(self.stack2.pop())
        
        return result

    def peek(self) -> int:
        """
        Get the front element.
        """
        for _ in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())
        
        result = self.stack2[-1]
        
        for _ in range(len(self.stack2)):
            self.stack1.append(self.stack2.pop())
        
        return result
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return True
        else:
            return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()