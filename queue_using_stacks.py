# Approach: Queues follow the FIFO which means we add elements from the rear and remove from the front
# While using a stack removal/pop is done based on LIFO hence we need 2 stacks, one for storing push operation (in_stack) and another one which reverses the order of the in stack, out_stack
# Anytime we push new values, we append it to the in_stack and when we need to remove an element, we transfer the contents from in to out stack and pop the top value
# Similar operation for peek, as peek in queue is for the front elements.
# (Amortized) Time complexity - O(1) for each operation independantly
# Space Complexity - O(N) as we use 2 separate stacks 
# Successfully ran on leetcode


class MyQueue():
    def __init__(self):
        self.in_stack = []
        self.out_stack = []


    def push(self, val):
        self.in_stack.append(val)


    def pop(self):
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

        return self.out_stack.pop()


    def peek(self):
        # we need to peek at the front of the queue, hence peek the value from the out_stack since it is reversing in_stack's order
        
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

        return self.out_stack[-1]

    def empty(self):
        return (not self.in_stack) and (not self.out_stack)