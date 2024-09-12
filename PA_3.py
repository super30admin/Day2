#Leetcode 232 : Implement Queue using Stacks
#Space Complexity - O(2n) [Overall]
class MyQueue(object):

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
        #Time Complexity - O(1)
        self.stack1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #Time Complexity - O(1) if Stack2 is not empty, else O(n)
        self.peek()
        x = self.stack2.pop()
        return x

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        #Time Complexity - O(1) if Stack2 is not empty, else O(n)
        if self.stack2 == []:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        #Time Complexity - O(1)
        return self.stack1 == [] and self.stack2 == []