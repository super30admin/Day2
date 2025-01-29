#push(): O(1) for each operation
#pop(): Amortized O(1)
#peek(): Amortized O(1)
#empty(): O(1)

#approach :- use stake1 for enqueue oprations
       # use stake 2 for dequeue oprations,that transfer the element when stack2 is empty


class MyQueue(object):

    def __init__(self):
        #intialize stacks
        self.st1 = []
        self.st2 = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """

        #Push element to the end of stack1
        
        self.st1.append(x)

    def pop(self):
        """
        :rtype: int
        """

        if not self.st2: # Check if stack2 is empty
            while self.st1:# Transfer elements from stack1 to stack2
                self.st2.append(self.stack1.pop())
        return self.st2.pop()# Pop and return the top of stack2 
        

    def peek(self):
        """
        :rtype: int
        """

        if not self.st2:
            while self.st1:
                self.st2.append(self.stack1.pop())
        return self.st2[-1] #Return the top of stack2

        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.st1 and not self.st2  # True if both stacks are empty
        
