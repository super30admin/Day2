#time complexity O(n)
#space complexity O(1)

class MyQueue:
    
    # Solved in O(n) time

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        popitem = self.stack2.pop()
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return popitem

    def peek(self) -> int:
        
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        ans = self.stack2[-1]
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return ans

    def empty(self) -> bool:
        if not self.stack1 and not self.stack2:
            return True
                               
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()