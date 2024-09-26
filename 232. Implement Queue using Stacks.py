# // Time Complexity : O(1) >> Average case
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : NO
# // Any problem you faced while coding this : Yes, I am Unable to understand whats wrong in the pop operation?


# // Your code here along with comments explaining your approach
# // Use two Stacks to make a queue
# // when new data is pushed then add it to insstack
# // when removing the data if the out stack is empty then move the instack to 
# // outstack and pop the element from the outstack

class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.instack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.outstack.pop()
        
    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.outstack:
            while(self.instack):
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.instack and not self.outstack:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

