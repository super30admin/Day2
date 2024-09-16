# Amortized time complexity for Push, Pop and Peek is O(1)
# Space Complexity is O(n)
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inp = []
        self.out = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.inp.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        self.peek()
        return self.out.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if(len(self.out) == 0):
            while(self.inp):
                self.out.append(self.inp.pop())
        return self.out[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if(len(self.inp) == 0 and len(self.out) == 0):
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()