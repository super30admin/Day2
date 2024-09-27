// Time Complexity : Push: O(1), pop : O(k) where k is number of elements in s1 till that point, peek : O(k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = [] # This is for push operation
        self.s2 = [] # This is for pop operation
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        
        self.s1.append(x)
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        t = self.peek()
        return self.s2.pop()
            
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.s2:
            while self.s1:
                t = self.s1.pop()
                self.s2.append(t)
        return self.s2[-1]
        
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.s1) == 0 and len(self.s2)==0
    	
        
    