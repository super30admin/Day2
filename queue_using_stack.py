"""
// Time Complexity : 
    push - O(1)
    pop - O(n)
    peek -  O(n)
    empty - O(1)

// Space Complexity : 
    O(n) for using stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
- We two stacks inbound stack used in case of push operation and outbound stack 
used in case of pop or peek operation
- move
    - popping the elements from inbound stack to outbound stack
- push
    - append the element to inbound stack
- peek
    - calling move
    - return stk[-1]
- pop
    - calling move
    - calling stk.pop()
- empty
    - chcking if both the stacks have any elements or no
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.in_stack.append(x)
        
    def move(self):
        if not self.out_stack:
            for _ in range(len(self.in_stack)):
                self.out_stack.append(self.in_stack.pop())

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #inserting the elements to empty stack and popping the first element
        self.move()
        return self.out_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        self.move()
        return self.out_stack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.out_stack and not self.in_stack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()