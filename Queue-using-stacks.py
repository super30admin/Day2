class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []
        self.count = 0

#Time Complexity O(1)
#Space Complexity O(n)

    def push(self, x: int) -> None:
        self.s1.append(x)
        self.count +=1
        
#Time Complexity O(n)
#Space Complexity O(n)
    def pop(self) -> int:
        if self.empty():
            return
        while self.s1:
            self.s2.append(self.s1.pop())
        x = self.s2.pop()
        while self.s2:
            self.s1.append(self.s2.pop())
        self.count -=1
        return x
#Time Complexity O(1)
#Space Complexity O(1)

    def peek(self) -> int:
        if self.empty():
            return
        return self.s1[0]

#Time Complexity O(1)
#Space Complexity O(1)
    def empty(self) -> bool:
        return self.count == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()