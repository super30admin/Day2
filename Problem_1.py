"""

    Student : Shahreen Shahjahan Psyche

    The Code Ran Successfully in Leetcode for all the test cases.

    Memory Complexity : O(N)
    
    Time Complexity:
        def push : O(N)
        def pop : O(N)
        def peek: O(1)
        def empty : O(1)

"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if len(self.pop_stack) != 0:
            while(self.pop_stack):
                self.push_stack.append(self.pop_stack.pop())
        self.push_stack.append(x)     

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.push_stack) == 0 and len(self.pop_stack) == 0:
            return
        if len(self.push_stack) != 0:
            while(self.push_stack):
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()
      

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.push_stack) != 0:
            return self.push_stack[0]
        elif len(self.pop_stack) != 0:
            return self.pop_stack[-1]
        else:
            return
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.push_stack) == 0 and len(self.pop_stack) == 0:
            return True
        return False
        
        
