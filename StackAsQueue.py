#space complexity is O(N)
#time complexity is amortized O(1)
class MyQueue:
    def __init__(self):
        self.in1 = []
        self.out = []

    def push(self, x: int) -> None:
        self.in1.append(x)
        
    def pop(self) -> int:
        if len(self.out)==0:
            while len(self.in1)>0:
                self.out.append(self.in1.pop(-1))
        return self.out.pop(-1)
        
    def peek(self) -> int:
        if len(self.out)==0:
            while len(self.in1)>0:
                self.out.append(self.in1.pop(-1))
        return self.out[-1]
        
    def empty(self) -> bool:
        return len(self.in1)==0 and len(self.out)==0
