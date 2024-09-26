#Time Complexity : O(n) for push operations
#Space Complexity : 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach:


class MyQueue:

    def __init__(self):
        #create two stacks
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        #append item to second stack that has been popped from first stack
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        self.stack1.append(x)
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())

    def pop(self) -> int:
        return self.stack1.pop()
        

    def peek(self) -> int:
        return self.stack1[len(self.stack1) - 1]

    def empty(self) -> bool:
        return self.stack1 == []

myQueue = MyQueue()
myQueue.push(1) #// queue is: [1]
myQueue.push(2) #// queue is: [1, 2] (leftmost is front of the queue)
print(myQueue.stack1)
print(myQueue.peek()) # // return 1
print(myQueue.pop()) #// return 1, queue is [2]
#print(myQueue.empty())# // return false
#print(myQueue.stack1)