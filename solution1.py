# Time Complexity : O(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyQueue:

    def __init__(self):
        self.stkin = []
        self.stkout = []        

    def push(self, x: int) -> None:
        self.stkin.append(x)

    def pop(self) -> int:
        if not self.stkout:
            while self.stkin:
                self.stkout.append(self.stkin.pop())
        return self.stkout.pop()

    def peek(self) -> int:
        if not self.stkout:
            while self.stkin:
                self.stkout.append(self.stkin.pop())
        return self.stkout[-1]

    def empty(self) -> bool:
        return not self.stkin and not self.stkout
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()