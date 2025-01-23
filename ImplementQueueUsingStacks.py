# Time Complexity: O(1) for push(), amortized O(1) for pop() and peek(), O(1) for empty().
# Space Complexity: O(n), where n is the total number of elements in the queue.
# Approach: Used two stacks (inStack and outStack) to implement FIFO behavior of a queue.

class MyQueue:

    def __init__(self):
        self.inStack = []  # Stack for pushing new elements
        self.outStack = []  # Stack for popping/peeking elements

    def push(self, x: int) -> None:
        self.inStack.append(x)  # Push to inStack

    def pop(self) -> int:
        self.peek()  # Ensure outStack is populated
        return self.outStack.pop()  # Pop from outStack

    def peek(self) -> int:
        if not self.outStack:  # If outStack is empty, transfer elements
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]  # Return the top element of outStack

    def empty(self) -> bool:
        # Queue is empty if both stacks are empty
        return not self.inStack and not self.outStack



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()