// Time Complexity : O(1) for append 
// Space Complexity : O(n) for all elements
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : I faced issue in understanding the stack transfers.


// Your code here along with comments explaining your approach

# Using two arrays as stacks 

from collections import deque

class MyQueue:
    
    # I used arrays as data structre for stack, 2 stacks, 2 arrays
    def __init__(self):
        self.myStack1 = []
        self.myStack2 = []
    

    #push the new item of the queue to first stack using append
    def push(self, x):
        self.myStack1.append(x)        
        
        
    #in pop operation, move all items of the first stack to second stack, when     #second stack is empty and fill it with all contents of stack 1.      
    def pop(self):
        
        if len(self.myStack2) == 0:
            while len(self.myStack1) != 0:
                self.myStack2.append(self.myStack1.pop())
        
        
        return self.myStack2.pop()
    
    
    # push all to second stack and return -1 element of final contents, as it is
    # the element which is in the front of the queue.
    def peek(self):
        
        if len(self.myStack2) == 0:
            while len(self.myStack1) != 0:
                self.myStack2.append(self.myStack1.pop())
         
        
        return self.myStack2[-1]
        
        
    
    def empty(self):
        if not self.myStack1 and not self.myStack2:
            #print('no element to pop, queue is empty')
            return True
            
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
