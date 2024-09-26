class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.

        Solving using two stacks
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

        1. If out_stack is empty, pop in_stack to out_stack
           Remove top element and return it

           Else
           Remove top element and return it
        """
        if len(self.out_stack) == 0:
            n = len(self.in_stack)
            for i in range(n):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop() # Return popped top element

    def peek(self) -> int:
        """
        Get the front element.

        Similar to pop(), but instead of removing top element, just return it
        """
        if len(self.out_stack) == 0:
            n = len(self.in_stack)
            for i in range(n):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]  # Top element

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.in_stack) == len(self.out_stack) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
