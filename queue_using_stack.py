# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
class MyQueue:

    def __init__(self):
    
        self.inStack, self.outStack = [], []

    def push(self, x):

        self.inStack.append(x)

    def pop(self):
   
        self.move()
        return self.outStack.pop()

    def peek(self):

        self.move()
        return self.outStack[-1]

    def empty(self):

        return (not self.inStack) and (not self.outStack) 
        
    def move(self):

        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()