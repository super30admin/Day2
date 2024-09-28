#implementing using two stacks
# push operation it's o(1) whereas pull and peek it's o(n)

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]# defining empty stack
        self.stack2=[]
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.stack1.append(x) #appending the value inside stack
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.stack2)!=0: #checking the stack2 is empyty aor not
            return self.stack2.pop()
        else:
            while len(self.stack1)!=0:
                self.stack2.append(self.stack1.pop()) # appending the values from stack1 to stack2
            return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.stack2)!=0:
            return self.stack2[-1]
        else:
            while len(self.stack1)!=0:
                self.stack2.append(self.stack1.pop())# doing the same operation as pop
            return self.stack2[-1]



    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return self.stack1 ==[] and self.stack2==[]
        