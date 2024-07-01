#TC push is O(1) and Pop is O(1) AVG 
class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0: #if outstach is not empty
            while len(self.inStack) > 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

        
    def empty(self) -> bool:
        return len(self.inStack) == 0 and  len(self.outStack)==0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()