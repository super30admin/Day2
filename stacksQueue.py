# Time Complexity : see below
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.iN = list()
        self.out = list()
        

    def push(self, x: int) -> None:
        # TC O(1)
        self.iN.append(x)

    def _populateOut(self):
        # TC O(n)
        if not self.out:
            while self.iN:
                self.out.append(self.iN.pop())

    def pop(self) -> int:
        # TC Amortized O(1) but worst case O(n)
        self._populateOut()
        return self.out.pop()

    def peek(self) -> int:
        # TC Amortized O(1) but worst case O(n)
        self._populateOut()
        return self.out[-1]
        

    def empty(self) -> bool:
        return self.iN == self.out and len(self.iN) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()