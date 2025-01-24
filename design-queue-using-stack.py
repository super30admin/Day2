'''
// Time Complexity : O(1)
// Space Complexity O(n)
// Did this code successfully run on Leetcode : yes.(#232)
// Any problem you faced while coding this : No.
'''

class MyQueue:

    def __init__(self):
        self.inStk = []
        self.outStk = []

    def push(self, x: int) -> None:
        self.inStk.append(x)

    def pop(self) -> int:
        self.peek()
        if self.outStk:
            return self.outStk.pop()

    def peek(self) -> int:
        if len(self.outStk)==0:
            while self.inStk:
                self.outStk.append(self.inStk.pop())
        return self.outStk[-1]
    
    def empty(self) -> bool:
        if len(self.outStk)==0 and len(self.inStk)==0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
obj.push(20)
print(obj.peek())
print(obj.pop())
print(obj.empty())
print(obj.peek())