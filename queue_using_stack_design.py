"""
Author: Srinidhi Bhat
Time Complexity: pop - O(1) push - O(n) 
Space Complexity: O(n) - Using Extra stack over then given stack
Leetcode: yes
Logic: Basically top of stack points to the top most element. In order to maintain the First in First Out logic of Queue
#We can maintain another auxiliary stack and while pushing into the original stack, first we will pop all the elements
#and then push the incoming element
# this will ensure the FIFO logic is maintained. 
"""
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        while self.s1:
            self.s2.append(self.s1.pop())
        
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop())
            
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.s1.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.s1[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.s1
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()