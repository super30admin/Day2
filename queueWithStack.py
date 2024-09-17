"""
So this is approach in which push: O(1)
pop: asymtotically O(1)
"""

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.s1.append(x)


    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        self.peek()
        if self.s2:
            return self.s2.pop()


    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.s2:   #if out stack is empty
            while self.s1:
                self.s2.append(self.s1.pop())

        return self.s2[-1]


    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return self.s1 == [] and self.s2 == []

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()