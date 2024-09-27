# Time Complexity : O(n) worst case
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:
    def __init__(self):  
        self.ino = []
        self.out = []
        
    def push(self, x: int) -> None:
        
        self.ino.append(x)
        

    def pop(self) -> int:
        
        if(len(self.out) == 0):
            while(len(self.ino)):
                self.out.append(self.ino.pop())
        return(self.out.pop())

    def peek(self) -> int:
        if(len(self.out) == 0 and len(self.ino) != 0):
            while(len(self.ino) != 0):
                self.out.append(self.ino.pop())
            return self.out[-1]
        if len(self.ino) == 0 and len(self.out) != 0:
            return self.out[-1]
        if self.empty: return -1

    def empty(self) -> bool:
        if len(self.ino) == 0 and len(self.out) == 0:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
obj.push(20)
obj.push(30)
param_2 = obj.pop()
print(param_2)
param_3 = obj.peek()
print(param_3)
param_4 = obj.empty()
print(param_4)