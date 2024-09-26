# // Time Complexity : omortized O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : YES
class MyQueue:

    def __init__(self):
        self.pushS=[]
        self.popS=[]

    def push(self, x: int) -> None:
        self.pushS.append(x)
        

    def pop(self) -> int:
        if not self.popS:
            for x in range(len(self.pushS)):
                self.popS.append(self.pushS.pop())
        return self.popS.pop()
        

    def peek(self) -> int:
        if not self.popS:
            for x in range(len(self.pushS)):
                self.popS.append(self.pushS.pop())
        return self.popS[-1]
        

    def empty(self) -> bool:
        if not self.popS and not self.pushS:
            return True
        return False
