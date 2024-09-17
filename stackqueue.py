'''
Time Complexity: O(1) - Push, Peek, Empty. O(N) - Worst case in Pop
Space Complexity: O(N)
'''
class MyQueue:

    def __init__(self):
        self.inarr = []
        self.out = []
        
    def push(self, x: int) -> None:
        self.inarr.append(x)

    def pop(self) -> int:
        if(len(self.out)==0 and len(self.inarr)>0):
            while(len(self.inarr)>0):
                temp = self.inarr.pop()
                self.out.append(temp)
        return self.out.pop()

    def peek(self) -> int:
        if(len(self.out)>0):
            return self.out[len(self.out)-1]
        return self.inarr[0]
        
    def empty(self) -> bool:
        if(len(self.inarr)==0 and len(self.out)==0):
            return True
        return False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()