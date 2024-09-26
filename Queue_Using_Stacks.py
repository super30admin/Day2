# Time Complexity : Push-> O(1), Pop -> O(n), Peek-> O(n), Empty-> O(1)
#  Space Complexity : O(n) one extra stack
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :  No
# Your code here along with comments explaining your approach

# Two stacks approach: One for Push operation and other for peeking and popping

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_peep_stack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        # add to push stack
        self.push_stack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # if pop peek stack is empty, transfer all elements from push stack
        if not self.pop_peep_stack:
            while self.push_stack:
                self.pop_peep_stack.append(self.push_stack.pop())
        # in any case pop from pop peek stack
        return self.pop_peep_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        # same as pop
        if not self.pop_peep_stack:
            while self.push_stack:
                self.pop_peep_stack.append(self.push_stack.pop())
        return self.pop_peep_stack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        # check if both are empty
        return not self.push_stack and not self.pop_peep_stack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()