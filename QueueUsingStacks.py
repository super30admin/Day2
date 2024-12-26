class MyQueue:

    def __init__(self):
        self.inst = []
        self.outst = []

    def push(self, x: int) -> None:
        # appends element to instack
        self.inst.append(x)
    
    def transfer():
        # transfers elements from instack to outstack
        while len(self.inst) > 0:
            self.outst.append(self.inst.pop())  

    def pop(self) -> int:
        # avg tc: O(1)
        # Transfers all elements to outstack if length of outstack is zero and removes last element in out stack
        if not self.outst:
            while len(self.inst) > 0:
                self.outst.append(self.inst.pop())
        return self.outst.pop()
        

    def peek(self) -> int:
        # avg tc: O(1)
        # Transfers all elements to outstack if length of outstack is zero and returns last element in out stack
        if not self.outst:
            while len(self.inst) > 0:
                self.outst.append(self.inst.pop())
        return self.outst[-1]
        

    def empty(self) -> bool:
        # Returns true if there are no elements in both out stack and in stack
        if len(self.inst) == 0 and len(self.outst) == 0:
            return True
        return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()