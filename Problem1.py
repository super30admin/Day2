// Time Complexity : amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 1. Declare 2 stacks
// 2. To maintain order of FIFO of queue each time we need to pop check if stack is empty,
//    transfer ekements to stack and perform pop opertion 
// 



class MyQueue:

    def __init__(self):
        self.instack =  [ ]
        self.outstack = [ ]
        

    def push(self, x: int) -> None:
        self.instack.append(x)
        

    def pop(self) -> int:
        if len(self.outstack) ==0:
            while(len(self.instack)!=0):
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()
        

    def peek(self) -> int:
        if len(self.outstack) ==0:
            while(len(self.instack)!=0):
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        return (len(self.instack)==0 and len(self.outstack)==0)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()