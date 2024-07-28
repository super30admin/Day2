# // Time Complexity : It is amortized since O(n) when arrayout is empty and arrayin is not empty otherwise it is O(1)
# // Space Complexity :
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : I did using my array and by having counter. How to understand the space complexity.


# // Your code here along with comments explaining your approach: Push in the arrayIn and when Pop action copy the data from arrayIn to arrayOut then O(1) till the arrayOut is empty.

import numpy as np
class MyQueue:

    def __init__(self):
        self.counterIn=0
        self.counterOut=0
        self.arrayIn=[]
        self.arrayOut=[]

       
        

    def push(self, x: int) -> None:
        self.arrayIn.append(x)
        self.counterIn +=1

    def pop(self) -> int:
        peek=self.peek()    
        self.counterOut -=1
        return peek
            
                
            

    def peek(self) -> int:
        if self.counterOut==0:
            self.arrayOut = np.zeros([100],dtype=int)
            while self.counterIn-1>=0:
          
                self.counterIn -=1    
                self.arrayOut[self.counterOut] = self.arrayIn[self.counterIn]
                self.counterOut +=1
        if self.counterIn==0:
            self.arrayIn=[]
        return self.arrayOut[self.counterOut-1]
                  
        

    def empty(self) -> bool:
        if(self.counterIn ==0 and self.counterOut==0):
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(1)
# obj.push(2)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
# obj.push(1)
# obj.push(2)
# param_3 = obj.peek()
# param_2 = obj.pop()

# param_4 = obj.empty()

#scenario
print(format("Push"),obj.push(1))
print(format("Push"),obj.push(2))
print(format("Push"),obj.push(3))
print(format("Push"),obj.push(4))
print(format("Pop"),obj.pop())
print(format("Push"),obj.push(5))
print(format("Pop"),obj.pop())
print(format("Pop"),obj.pop())
print(format("Pop"),obj.pop())
print(format("Pop"),obj.pop())


