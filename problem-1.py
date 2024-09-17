# Time Complexity : push - O(1), pop(amortized) - O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        self.move()
        return self.stack2.pop()
        

    def peek(self) -> int:
        self.move()
        return self.stack2[-1]
        
    def empty(self) -> bool:
        return (not self.stack1) and (not self.stack2)
    
    def move(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()