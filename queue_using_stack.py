# Time Complexity : O(1)                                                                                               
# Space Complexity :O(n)                                                                                               
# Did this code successfully run on Leetcode : Yes                                                                     
# Any problem you faced while coding this : Minor difficulty when I was putting logic which we discussed in Java to Python
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack =[]
        self.queue =[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.queue.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (len(self.queue)==0):
            while(len(self.stack)!=0):
                self.queue.append(self.stack.pop())
        out=self.queue[-1]   
        return out
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.queue)==0) and (len(self.stack)==0):
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()