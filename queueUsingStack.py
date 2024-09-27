class MyQueue(object):

    def __init__(self):
        self.s1=[]
        self.s2=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.s1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if len(self.s1) == 0 and len(self.s2) == 0:
            return None
        elif len(self.s1) > 0 and len(self.s2) == 0:
            while len(self.s1) != 0:
                temp = self.s1.pop
                self.s2.append(temp)
            return self.s2.pop
        else:
            return self.s2.pop
        

    def peek(self):
        """
        :rtype: int
        """
        if len(self.s1) == 0 and len(self.s2) == 0:
            return None
        elif len(self.s1) > 0 and len(self.s2) == 0:
            while len(self.s1) != 0:
                temp = self.s1.pop
                self.s2.append(temp)
            return self.s2[0]
        else:
            return self.s2[0]

    def empty(self):
        """
        :rtype: bool
        """
        if len(self.s1) == 0 and len(self.s2) == 0:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
