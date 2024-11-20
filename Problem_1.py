#Queue Using Stack 
#https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue:

    def __init__(self):
        self.index = 0
        self.stack = []
        

    def push(self, x: int) -> None:
        return self.stack.append(x)
        

    def pop(self) -> int:
        self.index = self.index + 1
        return self.stack[self.index-1]
        

    def peek(self) -> int:
        return self.stack[self.index]
        

    def empty(self) -> bool:
        if self.index >= len(self.stack):
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()