# // Time Complexity : average time complexity 0(1) worst case O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
class MyQueue(object):
# initialised two lists which act as stacks to have the ability to act as queue
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []


    def push(self, x):
# Append to first stack
        self.stack1.append(x)
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """


    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
# check if stack 2 is empty, if so push all elements from stack1 to stack 2 and pop from stack2
        if not self.stack2:
            while self.stack1:
                element = self.stack1.pop()
                self.stack2.append(element)
        return self.stack2.pop()


    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
# check if stack 2 is empty, if so push all elements from stack1 to stack 2 and peek from stack2
        if not self.stack2:
            while self.stack1:
                element = self.stack1.pop()
                self.stack2.append(element)
        return self.stack2[-1]


    def empty(self):
# check both the lengths of stacks if both are empty return true else return false
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if not self.stack1 and not self.stack2:
            return True
        else:
            return False



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
