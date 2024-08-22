# Time Complexity : push => o(1), amortized TC pop => o(1), amortized TC peek => o(1), empty => o(1)  
# Space Complexity : o(n)
# Did this code successfully run on Leetcode : Yes

class MyQueue:

    def __init__(self):
        self.s_in = []   #initializing push array
        self.s_out = []   #initializing pop array

    def push(self, x: int) -> None:
        self.s_in.append(x)

    def pop(self) -> int:
        if len(self.s_out) == 0:                    #if pop array is empty, push array is transferred to maintain property of FIFO
            while len(self.s_in) != 0:
                self.s_out.append(self.s_in.pop())
        return self.s_out.pop()        

    def peek(self) -> int:
        if len(self.s_out) == 0:
            while self.s_in:
                self.s_out.append(self.s_in.pop())
        return self.s_out[-1]        

    def empty(self) -> bool:
        return len(self.s_in) + len(self.s_out) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()