# Time Complexity : push => O(1)
#                   pop => O(1) - amortized TC as long as there's n elements in stack_2, pop is in O(1) n times, but when stack_2 is empty we need to transfer from stack_1 
#                                 to stack_2 which is O(n) 1 time.
# Space Complexity : O(n) - n : length of the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Earlier, whenever I transferred to stack_2 for pop or peek operation, I transferred back to stack_2 which was unecessary.
#
# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack_1 = []
        self.stack_2 = []
        
    # Enqueue operation: Pushing element to stack
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack_1.append(x)
        
  # Dequeue operation: If stack_2 is empty, then pop all elements of stack_1 and push to stack_2 one by one. Then pop the top of stack_2. 
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack_2) <= 0:
            if len(self.stack_1) > 0:
                for _ in range(len(self.stack_1)):
                    self.stack_2.append(self.stack_1.pop(-1))
            else:
                print("ERROR: Stack Underflow")
        return self.stack_2.pop(-1)
        
  
    # Returns the front element (same approach as Dequeue - only difference is we are returning the top of stack_2 and not popping it)
    def peek(self) -> int:
        """
        Get the front element.
        """
       if len(self.stack_2) <= 0:
            if len(self.stack_1) > 0:
                for _ in range(len(self.stack_1)):
                    self.stack_2.append(self.stack_1.pop(-1))
            else:
                print("ERROR: Stack Underflow")
        return self.stack_2[-1]
        
    # To check if queue is empty - both stack_1 and stack_2 must be empty
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack_1) == 0 and len(self.stack_2) == 0:
            return True
        else:
            return False
        
