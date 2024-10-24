# Time Complexity : 
# - push: O(1)
# - pop: O(n) in the worst case (when the second stack is empty and we need to transfer elements)
# - peek: O(n) in the worst case (same reason as pop)
# - empty: O(1)
# 
# Space Complexity : O(n), where n is the number of elements in the queue.
#
# Did this code successfully run on Leetcode : Yes
#
# Any problem you faced while coding this : No significant issues, just ensuring proper transfer of elements between stacks.

class MyQueue:

    def __init__(self):
        # Initialize two stacks: one for input and one for output
        self.input_stack = []   # Stack to hold incoming elements
        self.output_stack = []  # Stack to hold elements for popping

    def push(self, x: int) -> None:
        # Push the element onto the input stack
        self.input_stack.append(x)

    def pop(self) -> int:
        # Ensure the output stack has elements to pop
        self.peek()  # This will populate the output stack if it's empty
        return self.output_stack.pop()

    def peek(self) -> int:
        # If the output stack is empty, transfer elements from input stack
        if not self.output_stack:
            while self.input_stack:
                # Pop from input stack and push to output stack
                self.output_stack.append(self.input_stack.pop())
        # Return the top element of the output stack (front of the queue)
        return self.output_stack[-1]

    def empty(self) -> bool:
        # The queue is empty if both stacks are empty
        return not self.input_stack and not self.output_stack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
