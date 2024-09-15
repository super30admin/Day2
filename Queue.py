# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach



class MyQueue:
    def __init__(self):
        self.inStack = []
        self.outStack = []
    
    def push(self, x: int) -> None:
        self.inStack.append(x)
        

    def pop(self) -> int:
        self.peek();
        return self.outStack.pop()

    def peek(self) -> int:
        
        if self.outStack == []:
            while self.inStack != [] :
                self.outStack.append(self.inStack.pop())
                
        return self.outStack[len(self.outStack)-1]

    def empty(self) -> bool:
        return (self.inStack== []) and (self.outStack == [])
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()