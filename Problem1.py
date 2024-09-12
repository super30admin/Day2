'''
Time Complexity: O(1) average for all operations
Space Complexity: O(n) n is the size of stacks combined
Run on Leetcode: YES
Problems: To manage both stacks such that alternate popping and pushing does not affect each other.
'''

class MyQueue:

    def __init__(self):
        self.S1 = []
        self.S2 = []

    def push(self, x: int) -> None:
        self.S1.append(x)
        

    def pop(self) -> int:
        if len(self.S2) > 0:
            return self.S2.pop()
        while len(self.S1) > 0:
            self.S2.append(self.S1.pop())
        return self.S2.pop()
        

    def peek(self) -> int:
        if len(self.S2) > 0:
            return self.S2[len(self.S2) - 1]
        while len(self.S1) > 0:
            self.S2.append(self.S1.pop())
        return self.S2[len(self.S2) - 1]
        

    def empty(self) -> bool:
        return len(self.S1) == 0 and len(self.S2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()