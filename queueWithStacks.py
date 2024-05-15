# Time Complexity : Push - O(1), Pop - O(1) (amortized), Peek - O(1) (amortized), empty - O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class MyQueue:
    def __init__(self):
        self.in_stack = [] # Maintains the incoming elements
        self.out_stack = [] # Maintains the outgoign elements

    def push(self, x: int) -> None:
        self.in_stack.append(x) # Push element to IN stack

    def pop(self) -> int:
        self.peek() # Transfers the elements to the OUT stack if needed
        return self.out_stack.pop() # Pop the topmost element from the OUT stack

    def peek(self) -> int:
        if not self.out_stack: # If the OUT stack is empty, fill with the elements from the IN stack. Else, return the topmost element from the OUT stack
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack # Queue is empty if both IN and OUT stacks are empty

# Example usage
queue = MyQueue()
queue.push(1)
queue.push(2)
print(queue.peek())  # Output: 1
print(queue.pop())   # Output: 1
print(queue.empty()) # Output: False
