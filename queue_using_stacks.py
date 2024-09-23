class MyQueue(object):
    # idea is to have two stacks wherre elements are moved in between stacks to behave like a queue
    # because the elements become FIFO on when moved to the other stack
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        # if self.out_stack is empty, move all the elements by popping from in_stack to out_stack
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        # if self.out_stack is empty, move all the elements from in_stack to out_stack and return the topmost element from outstack
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return not self.in_stack and not self.out_stack


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(22)
obj.push(23)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
print(param_2, param_2, param_3, param_4)

# the amortized time complexity for push,pop,peek and empty method is O(1)
# the best space complexity is O(n)where n is the number of elements
