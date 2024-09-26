# Time Complexity: O(1)
# Space Complexity: O(n)
class MyQueue:

    def __init__(self):
        self.inp =[]
        self.out =[]
        

    def push(self, x: int) -> None:
        self.inp.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out.pop()
        

    def peek(self) -> int:
        if len(self.out)==0:
            while len(self.inp)!=0:
                self.out.append(self.inp.pop())
        return self.out[-1]
            
        

    def empty(self) -> bool:
        if len(self.inp)==0 and len(self.out)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()