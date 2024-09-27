# // Time Complexity :O(1)
# // Space Complexity :O(n)
class MyQueue:

    def __init__(self):
        self.inst=[]
        self.outst=[]
        

    def push(self, x: int) -> None:
        self.inst.append(x)
        

    def pop(self) -> int:
        if self.peek():
            return self.outst.pop()
        
        

    def peek(self) -> int:
        if len(self.outst)==0:
            while len(self.inst)!=0:
                temp=self.inst.pop()
                self.outst.append(temp)
                
        return self.outst[-1]
        

    def empty(self) -> bool:
        if len(self.outst)==0 and len(self.inst)==0:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()