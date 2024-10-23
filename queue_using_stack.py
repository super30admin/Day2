from collections import deque
class MyQueue:

    def __init__(self):
        self.q = deque()
        self.count = 0
        

    def push(self, x: int) -> None:
        self.q.append(x)
        self.count+=1
        

    def pop(self) -> int:
        if self.count >=1:
            self.count-=1
            return self.q.popleft() 

    def peek(self) -> int:
        return self.q[0]
        

    def empty(self) -> bool:
        return self.count == 0


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(150)
obj.push(130)
obj.push(120)
obj.push(110)
obj.push(10)
param_2 = obj.pop()
print(param_2)
param_3 = obj.peek()
print(param_3)
param_4 = obj.empty()
print(param_4)