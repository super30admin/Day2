# // Time Complexity : O(1) Except for popping when there is no element in out stack
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We use two stacks IN and OUT for this
# Whenever new element is inserted we insert that into the IN stack and whenever we want to pop or peek we look into the 
# OUT stack. When out stack is empty we empty the IN stack and push those elements in OUT stack.
# we need to do this operation for SEEK only not for pop as we can reuse the code in pop from SEEK
class MyQueue:
   
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.ins = []
        self.out = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.ins.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.out.pop()
        
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.out)==0:
            while(len(self.ins) != 0):
                element = self.ins.pop()
                self.out.append(element)
            
        return self.out[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.ins) == 0 and len(self.out) == 0
