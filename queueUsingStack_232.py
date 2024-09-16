###
'''
push - O(1)

pop - O(1)

peek - O(1)

space - O(n)

Method - Have two arrays In and out. When peek or pop is called and Out stack is empty, push the items to out stack and pop the top element. If the outstack has values, directly pop or peek the top element.

Push the elements to the in stack
'''

####

import collections

class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(len(self.outStack) > 0):
            return self.outStack.pop()
        else:
            self.peek()
            return self.outStack.pop()
        
    def peek(self) -> int:
        """
        Get the front element.
        """
        if(len(self.outStack)==0):
            if(len(self.inStack)>0):
                while(len(self.inStack)!=0):
                    self.outStack.append(self.inStack.pop())

        return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.inStack) == 0 and len(self.outStack)==0):
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
myQueue = MyQueue()
# myQueue.push(1); #queue is: [1]
# #myQueue.push(2); #// queue is: [1, 2] (leftmost is front of the queue)
# print(myQueue.peek()); #// return 1
# myQueue.pop(); #// return 1, queue is [2]
# print(myQueue.empty()); #// return false


myQueue.push(1);
print(myQueue.pop())
print(myQueue.empty())