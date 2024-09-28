#Time complexity for put and get: O(1) amortized
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inSt = []
        self.out = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.inSt.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        el = self.peek()
        self.out.pop()
        return el
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.empty():
            if len(self.out) > 0:
                return self.out[-1]
            else:
                while len(self.inSt)!=0:
                    self.out.append(self.inSt.pop())
                return self.out[-1]
        else:
            return None
            

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if len(self.inSt) == 0 and len(self.out) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()