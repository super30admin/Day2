# Time Complexity : 28
#  Space Complexity : 14
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : For one case I had wrong output as the else condition was not handled correctly


#  Your code here along with comments explaining your approach
class MyQueue:

    #Define two stacks to manipulate them as queue and make the stack reverse in order
    def __init__(self):
        self.stackA = []
        self.stackB = []

    #append elements in first stack
    def push(self, x: int) -> None:
        self.stackA.append(x)
        
    #Reversing the stack by popping the first and appending it to second, return the element at top of second stack
    def pop(self) -> int:
        if not self.stackB:
            while self.stackA:
                self.stackB.append(self.stackA.pop())
        return self.stackB.pop()
    
    #Repeats the same process of popping and pushin the element to second stack, returns the top element of second stack
    def peek(self) -> int:
        if not self.stackB:
            while self.stackA:
                self.stackB.append(self.stackA.pop())
        return self.stackB[-1]
    
    #if both stacks are empty return true
    def empty(self) -> bool:
        return not self.stackA and not self.stackB


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()