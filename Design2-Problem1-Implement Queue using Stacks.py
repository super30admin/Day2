"""
Problem 1
232. Implement Queue using Stacks

Time Complexity : 
    Operation:  
        Push( ) : O(1)
        Pop()   : O(N)
        Empty() : O(1)
        Peek()  : O(N)

Space Complexity : O(N) 

Did this code successfully run on Leetcode : Yes

Two Stack is used to replicate the functionality of Oueue (FIFO)

ArrayList is used to represent the Stack
 Two Stack inStack and outStack
 
Whenwe have to push an element: Its pushed in inStack
When we want to pop the element, as we have to pop the First element nad Stack isa LIFO strcture,
All the values from inStack is moved to outStack if the outStack is empty, else the top of ourStack is returned
if there are elements 


    

@name: Rahul Govindkumar_RN27JUL2022
"""



class MyQueue:

    def __init__(self):
        
        self.inStack=[]
        self.outStack = []
        

    def push(self, x: int) -> None: #O(1)
        self.inStack.append(x)

    def pop(self) -> int: #O(N)
        self.peek()
        
        return self.outStack.pop()
        

    def peek(self) -> int: 
        
        if(len(self.outStack)==0):
            while(len(self.inStack) !=0):
                self.outStack.append(self.inStack.pop())
                
        return self.outStack[-1]
            
        

    def empty(self) -> bool:
        
        if(len(self.outStack)==0 and len(self.inStack)==0  ):
            return True
        
        return False
        
       
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


"""
Problem 1
232. Implement Queue using Stacks

Time Complexity : 
    Operation:  
        Push( ) : O(1)
        Pop()   : O(N)
        Empty() : O(1)
        Peek()  : O(N)

Space Complexity : O(N) 

Did this code successfully run on Leetcode : Yes

Two Stack is used to replicate the functionality of Oueue (FIFO)

Dequeue is used to represent the Stack
 Two Stack inStack and outStack
 
Whenwe have to push an element: Its pushed in inStack
When we want to pop the element, as we have to pop the First element nad Stack isa LIFO strcture,
All the values from inStack is moved to outStack if the outStack is empty, else the top of ourStack is returned
if there are elements 


    

@name: Rahul Govindkumar_RN27JUL2022
"""


class MyQueue:

    def __init__(self):
        
        self.inStack=deque()
        self.outStack = deque()
        

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        
        return self.outStack.pop()
        

    def peek(self) -> int:
        
        if(len(self.outStack)==0):
            while(len(self.inStack) !=0):
                self.outStack.append(self.inStack.pop())
                
        return self.outStack[-1]
            
        

    def empty(self) -> bool:
        
        if(len(self.outStack)==0 and len(self.inStack)==0  ):
            return True
        
        return False
        
       
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()