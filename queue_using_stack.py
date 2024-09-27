'''
Time Complexity : O(1) for each operation
Space Complexity : O(n) for all elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
#Use 2 stacks in order to pop the first element of the queue. We first push each element of 1st stack one by one to the 2nd stach,
#and then pop the last element of the 2nd stack for the pop() operation.
'''



class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack2) != 0:
            return self.stack2.pop()

        else:
            while (len(self.stack1) != 0):
                self.stack2.append(self.stack1.pop())

            return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack2) != 0:
            return self.stack2[-1]

        else:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())

            return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """

        return not (self.stack1 or self.stack2)

    # Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()