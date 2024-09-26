# Time Complexity : push: O(1), pop: O(n) - worst case, peek: O(n), empty: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We take 2 stacks for this problem. One stack will store all the elements of the queue as they get pushed.
#2. As we pop the elements, we need to reverse the stack, to get the front of the queue, to do this, we will pop all the elements from stack1 and
# push them into another stack, top of which will give the front of the queue.
#3. Push will continue appending elements in first stack, pop will check in stack 2, if we have something, we will return, or else we will pop all the elements from
# stack 1 and push them in stack 2 and return the top of stack 2.

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
        self.stack1.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.stack2) != 0:
            return self.stack2.pop()
        else:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.stack2) != 0:
            return self.stack2[-1]
        else:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
