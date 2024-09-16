# Design queue using stack (https://leetcode.com/problems/implement-queue-using-stacks/submissions/)
# Time complexity: push()=O(1), peek()=O(1), pop()=O(1), isEmpty()=O(1) 
# Space complexity: O(n), where n=number of elements
# Did this code successfully run on Leetcode : Yes
# Approach: Used two stacks, in and out. Use in stack to push values and used out stack to peek and pop the values

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_s = []
        self.out_s = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.in_s.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.out_s.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """

        if len(self.out_s) == 0:
            while len(self.in_s) > 0:
                self.out_s.append(self.in_s.pop())
                
        return self.out_s[-1]
                

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if ( len(self.in_s) == 0 and len(self.out_s) == 0 ):
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()