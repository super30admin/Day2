# Push constant time, Pop: O(n). Could do other way round as well.

class MyQueue(object):

    def __init__(self):
        self.instack = []
        self.outstack = []

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.instack.append(x)

    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def pop(self):
        """
        :rtype: int
        """
        if self.outstack == [] and self.instack != []:
            while self.instack != []:
                self.outstack.append(self.instack.pop())
            return self.outstack.pop()
        return self.outstack.pop()

    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def peek(self):
        """
        :rtype: int
        """
        if self.outstack == [] and self.instack != []:
            while self.instack != []:
                self.outstack.append(self.instack.pop())
            return self.outstack[-1]
        return self.outstack[-1]

    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def empty(self):
        """
        :rtype: bool
        """
        return self.instack == [] and self.outstack == []

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()