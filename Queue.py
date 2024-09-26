#implementing queue using stacks
class MyQueue(object):

    def __init__(self):
        self.sin=[]
        self.sout=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.sin.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.sout.pop()


    def peek(self):
        """
        :rtype: int
        """
        
        if len(self.sout)==0:
            while self.sin:
                self.sout.append(self.sin.pop())
        return self.sout[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        if (len(self.sin)==0 and len(self.sout)==0):
            return True
        else:
            return False
        


