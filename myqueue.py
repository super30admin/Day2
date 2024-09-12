# // Time Complexity : On avaerage O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no

class MyQueue(object):

    def __init__(self):
        self.stack = []
        self.stack2 = []
        

    def push(self, x):
  
        self.stack.append(x)
        

    def pop(self):
  
        self.peek()                             #if stack2 is empty, then transfer, if not, then just pop that stack
        return self.stack2.pop()
            
        

    def peek(self):
                                                                #if the second stack is empty, we push all the elements of the first stack to the second one, and then return the top of the second stack
        if not self.stack2:
            while self.stack:
                self.stack2.append(self.stack.pop())
            
        return self.stack2[-1]
        

    def empty(self):

        return True if self.stack==[] and self.stack2 ==[] else False
        
