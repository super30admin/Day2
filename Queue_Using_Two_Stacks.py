class MyQueue(object):

    '''
    Solution:
    1. Maintain two stacks whose main responsibilities are push (stack 1) and pop (stack 2) respectively.
    2. Push elements to Stack 1 without any complications.
    3. Pop elements from Stack 2 after pushing from Stack 1 if Stack 2 is empty and directly pop top element if
        elements are present in Stack 2.

    --- This code successfully ran on Leetcode.
    '''

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        self.stack1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # O(1) Time Complexity (best and average)| O(n) Time Complexity (worst)
        # O(n) Space Complexity
        if (len(self.stack2) == 0):
            self.transfer()
        return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # O(1) Time Complexity (best and average)| O(n) Time Complexity (worst)
        # O(n) Space Complexity
        if (len(self.stack2) == 0):
            self.transfer()
        return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        # O(1) Time Complexity | O(1) Space Complexity
        return (len(self.stack1) == 0 and len(self.stack2) == 0)

    def transfer(self):
        '''
        Push elements from stack 1 to stack 2
        :rtype: None
        '''
        while (len(self.stack1) > 0):
            self.stack2.append(self.stack1.pop())

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()