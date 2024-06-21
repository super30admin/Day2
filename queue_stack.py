"""
Time Complexity: O(n)
Space compexity: O(n)
"""


class MyQueue:
    def __init__(self):
        self.instack = []
        self.outstack = []

    def intooutstack(self):
        if len(self.instack) != 0:
            i = len(self.instack) - 1

            while(i >= 0):
                self.outstack.append(self.instack[i])
            
                i -= 1   
            self.instack = []

    def push(self, x: int) -> None:
        self.instack.append(x)
        

    def pop(self) -> int:
        if(len(self.outstack) == 0):
            self.intooutstack()
        return self.outstack.pop()
        

    def peek(self) -> int:
        if len(self.outstack) == 0:
            self.intooutstack() 
        return self.outstack[-1]      

    def empty(self) -> bool:
        if len(self.instack) == 0 and len(self.outstack) == 0:
            return True
        return False
        

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.pop()
obj.peek()
print(obj.empty())