# Time Complexity : O(1)
# Space Complexity : O(N) N=number of elements in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Your code here along with comments explaining your approach



class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.pushStack=[]
        self.peekPopStack=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        
        self.pushStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        
        if len(self.peekPopStack)==0:
            
            self.populatepeekPopStack()
        
        return self.peekPopStack.pop(-1)
        
    def populatepeekPopStack(self):
        while(len(self.pushStack)!=0):
                
            self.peekPopStack.append(self.pushStack.pop(-1))
        
        
    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.peekPopStack)==0:
            
            self.populatepeekPopStack()
        
        return self.peekPopStack[-1]
        
    
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        
        if len(self.peekPopStack)==0 and len(self.pushStack)==0:
            return True
        
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()