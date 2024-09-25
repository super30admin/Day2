# Time Complexity: O(1)
# Space Complexity : O(1)

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []

    def push(self, x):

        if len(self.stack) < 9:
            self.stack.append(x)
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """

    def pop(self):
        # As we are implementing queue using stack , we always need to pop first element in stack
        if (len(self.stack) != 0):
            return self.stack.pop(0)
        else:
            print("Stack is Empty")
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """

    def peek(self):

        #  As it is Queue implementation, we need to return first element in stack

        return self.stack[0]

        """
        Get the front element.
        :rtype: int
        """

    def empty(self):
        # Checking the length of the stack
        return len(self.stack) == 0
        """
        Returns whether the queue is empty.
        :rtype: bool
        """

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()