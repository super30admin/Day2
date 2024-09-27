# pop and peek takes O(n) time
# push and empty takes O(1) time
# indiviual methods doesn't take any space but we use O(n) space for stacks 
class MyQueue:
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)
        
    def pop(self) -> int:
        return self.transferValues()

    def peek(self) -> int:
        return self.transferValues(True)
        
    def empty(self) -> bool:
        return len(self.s1) == 0 and len(self.s2) == 0

    def transferValues(self,isPeak = False):
        if not len(self.s2):
            if not(len(self.s1)):
                return -1
            while len(self.s1):
                self.s2.append(self.s1.pop())
        return self.s2.pop() if not isPeak else self.s1[-1]

