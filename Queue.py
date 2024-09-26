# # // Time Complexity : O(1)
# # // Space Complexity : O(1)
# # // Did this code successfully run on Leetcode : yes

class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)
    
    def transfer(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        

    def pop(self) -> int:
        self.transfer()
        return self.s2.pop()
        

    def peek(self) -> int:
        self.transfer()
        return self.s2[-1]
        

    def empty(self) -> bool:
        if not self.s1 and not self.s2:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()