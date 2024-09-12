# Time Complexity :
#   push:   O(n)
#   pop:    O(1)
#   top:    O(1)
#   empty:  O(1)
# 
# Space Complexity : O(n) [n is the number of elements inserted into Stack]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. Two stack(main_stack and aux_stack) are used to implement the queue operations 
# 2. When a new element needs to enqueued, the existing elements are popped from the main_stack and pushed in to the aux_stack. The new element is pushed on to the main stack. At the end, all the elememts in the aux_stack are popped out and pushed on to the main_stack. 
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_stack = []
        self.aux_stack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if len(self.main_stack) == 0:
            self.main_stack.append(x)
        else:
            while self.main_stack:
                self.aux_stack.append(self.main_stack.pop())
            self.main_stack.append(x)
            while self.aux_stack:
                self.main_stack.append(self.aux_stack.pop())
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.main_stack:
            return self.main_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.main_stack:
            return self.main_stack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return False if len(self.main_stack) > 0 else True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()