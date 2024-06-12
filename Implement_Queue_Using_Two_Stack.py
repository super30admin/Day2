# Created by Aashish Adhikari at 12:02 PM 12/23/2020

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """

        # Simulate two stacks using the standard deque from python
        from collections import deque
        self.IN_stack = deque() # to push in incoming order
        self.OUT_stack = deque() # to pop in FIFO order


    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """

        # Always push into the IN_stack
        self.IN_stack.append(x)


    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """



        _ = self.peek() # reusing the peek() to avoid redundant code

        return self.OUT_stack.pop()


    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.OUT_stack) == 0:

            for idx in range(len(self.IN_stack)):
                self.OUT_stack.append(self.IN_stack.pop())

        return self.OUT_stack[len(self.OUT_stack)-1]

    # Since the questions says all peek operations are valid,
    # we do not have to handle the case when there is no element in the queue
    # and a peek() is requested.





    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if len(self.IN_stack) == 0 and len(self.OUT_stack) == 0:
            return True
        return False




# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()