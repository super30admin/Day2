// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self): # using two stacks so that 1. push and 2. popandPeek can be used 
        """
        Initialize your data structure here.
        """
        self.pushstack=[]
        self.popPeekstack=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if len(self.pushstack)==0:
            self.pushstack.append(x)
            return
        self.pushstack.append(x)
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.popPeekstack == []:
            while len(self.pushstack)!=0:
                self.popPeekstack.append(self.pushstack.pop())
        return self.popPeekstack.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.popPeekstack == []:
            while len(self.pushstack)!=0:
                self.popPeekstack.append(self.pushstack.pop())
        return self.popPeekstack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.pushstack)==0 and len(self.popPeekstack)==0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()