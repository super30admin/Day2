# Time Complexity : push:- O(1) pop:- amortized cost:- O(1), peek:- O(1) empty:- O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Idea:- Maintain Two stacks. Every time you encounter push, push to first stack, when you encounter pop, we need to get the bottom most element of the stack.
# Remove all the elements from the first stack and push it onto the second stack and then pop the first element. Now everytime we have to pop we will pop from 
# the second stack and everytime we have to push we will push to the first stack.
# We will keep on doing this until the second stack is empty at which point we will again remove all the elements from the first stack and continue with the process.

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first_stack=[]
        self.second_stack=[]
        
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.first_stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.second_stack)==0:
            while(len(self.first_stack)!=0):
                self.second_stack.append(self.first_stack.pop())
        return self.second_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.second_stack)==0:
            return self.first_stack[0]
        return self.second_stack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.first_stack)==0 and len(self.second_stack)==0