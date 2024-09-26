'''// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''

from collections import deque
class MyQueue(object):

    def __init__(self):
        #Input stack
        self.stack1=deque()
        
        #Output Stack
        self.stack2=deque()

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        #Append only in the input stack
        self.stack1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        #If both the stacks are empty
        if self.empty():
            print("Queue is empty")
            
         #else if only when ouput stack is empty
        elif len(self.stack2) ==0:
            #Transfer elements from input stack to output stack until input stack is not empty
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
                
        #return the removed top element from the output stack 
        return self.stack2.pop()
    
    def peek(self):
        """
        :rtype: int
        """
        #If both the stacks are empty
        if self.empty():
            print("Queue is empty")
        #else if only when ouput stack is empty
        elif len(self.stack2) ==0:
            #Transfer elements from input stack to output stack until input stack is not empty
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
         
         #return the top element from the output stack, Don't remove
        return self.stack2[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return (len(self.stack1)==0 and len(self.stack2)==0)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
