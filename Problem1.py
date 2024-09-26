#Time Complexity
#Push, isEmpty - O(1); Pop, Peek - O(N), Amortized O(1)

#Space Complexity
# O(1)

# Accepted on Leetcode

# Approach: Maintain two stacks - In and Out, always push to In
# For pop - Check Out, if element exists then pop from Out, else empty In stack into Out stack and pop
# Peek - Same as pop, except last step where we peek from the Out stack instead of popping
# Empty - check if both stacks are empty and return true/false accordingly


class MyQueue:

    def __init__(self):
        self.stackIn = []
        self.stackOut = [] 
        

    def push(self, x: int) -> None:
        self.stackIn.append(x)

    def pop(self) -> int:
        self.transferStackInToOut()
        return self.stackOut.pop()

    def peek(self) -> int:
        self.transferStackInToOut()
        return self.stackOut[-1]
    
    def transferStackInToOut(self):
        if len(self.stackOut) == 0:
            while len(self.stackIn):
                transferElem = self.stackIn.pop()
                self.stackOut.append(transferElem)
        

    def empty(self) -> bool:
        return len(self.stackOut) == 0 and len(self.stackIn) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()