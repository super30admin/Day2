class MyQueue:
    """
    // Time Complexity :
                O(n) We need to copy all elements from stack to another
    // Space Complexity :
                O(n) The number of elements in the stack
    // Did this code successfully run on Leetcode :
                Yes
    // Any problem you faced while coding this :
                I initially got confused with the index for the peek operation.
    """
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

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.out_stack:
            return self.out_stack.pop()
        else:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.out_stack:
            return self.out_stack[-1]
        elif self.in_stack:
            return self.in_stack[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.in_stack and not self.out_stack

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
