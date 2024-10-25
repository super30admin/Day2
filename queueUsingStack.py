# We will use two stacks to implement the queue.  A queue is FIFO. there will be an inStack and outStack.
# always push element in inStack
# when outStack is empty we will copy all elements from inStack to outStack then top element is popped. Same for peek
# // Time Complexity : O(1). Perfect O(1) for push. For peek and pop only the first pop which invokes the while loop is O(n) otherwise it is O(1) 
# // Space Complexity : O(n) . 2n for inStack and outStack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class MyQueue:


    def __init__(self):
        self.inStack = []                                      # elements go in inStack
        self.outStack = []                                     # elements come out of outStack

    def push(self, x: int) -> None:
        self.inStack.append(x)                                 # always push in inStack     
    

    def pop(self) -> int:                                       # whenever pop is called    
        if self.outStack==[]:                                   # if outStack is empty
            while self.inStack!=[]:                             # if instack is not empty    
                self.outStack.append(self.inStack.pop())        # copy all elements from inStack to outStack
        return self.outStack.pop()                              # pop top element from outStack  


    def peek(self) -> int:              
        if self.outStack==[]:                                   # same logic as pop        
            while self.inStack!=[]:                             # 
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]    

    def empty(self) -> bool:
        if self.inStack==[] and self.outStack==[]:
            return True
        else:
            return False 


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(4)
obj.push(5)
obj.push(6)
obj.push(7)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
print(param_2)
print(param_3)
print(param_4)