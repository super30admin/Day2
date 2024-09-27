'''
Take 2 stacks, instack and outstack. When push operation is called, add the element to instack. When pop or peek is called, put values from instack to outstack. This will 
act as FIFO for queue. 

Runs successfully in leetcode
Space complexity: Amortized O(1)
Time complexity: Amortized O(1)
'''
class MyQueue:

    def __init__(self):
        self.instack = []
        self.inCount = 0
        self.outstack = []
        self.outCount = 0
        

    def push(self, x: int) -> None:
      
        # Add element to instack
        #Time complexity: O(1)
        
        self.instack.append(x)
        self.inCount += 1
        

    def pop(self) -> int:
      
        # If both stacks are not empty, Add elements to outstack from instack if outstack is empty, then pop element from outstack.
        # Time complexity: Amortized O(1)
        
        
        if self.empty():
            return -1
        if self.outCount==0 and self.inCount>0:
            for i in range(self.inCount):
                self.outstack.append(self.instack.pop())
                self.inCount -= 1
                self.outCount += 1
        
        self.outCount -= 1
        return self.outstack.pop()
                      

    def peek(self) -> int:
      
        # If both stacks are not empty,Add elements to outstack from instack if outstack is empty, then return element from outstack.
        # Time complexity: Amortized O(1)
       
        if self.empty():
            return -1
        if self.outCount==0 and self.inCount>0:
            for i in range(self.inCount):
                self.outstack.append(self.instack.pop())
                self.inCount -= 1
                self.outCount += 1
                
        return self.outstack[-1]
        


    def empty(self) -> bool:
      
        #O(1)
        
        if self.inCount == 0 and self.outCount == 0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
