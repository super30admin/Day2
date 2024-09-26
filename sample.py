#Time Complexity :O(1) for push and amortized O(1) for pop and peek
#Space Complexity :O(n) , where n is the number of elements
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : writing the pop function and complexity calculation
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #initialized two stacks inStack and outStack
        self.inStack=[]
        self.out=[]
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        #push data in s1
        self.inStack.append(x)
        

    def pop(self):
        
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #if out stack is not empty, pop from out stack
        if self.out != []:
            return self.out.pop()
        #if in stack is also empty, no data is available
        elif self.inStack == []:
            print ("Queue is Empty")
            
        #pop till in stack is empty and add to out stack and pop from out stack
        else:
            while (self.inStack != []):
                poppedItem=self.inStack.pop()
                self.out.append(poppedItem)
            return self.out.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.out != []:
            return self.out[-1]
        #if in stack is also empty, no data is available
        elif self.inStack == []:
            print ("stack is empty")
            
        #pop till in stack is empty and add to out stack and pop from out stack
        else:
            while (self.inStack != []):
                poppedItem=self.inStack.pop()
                self.out.append(poppedItem)
        return self.out[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if (len(self.inStack)==0) and (len(self.out)==0):
            return True
        





