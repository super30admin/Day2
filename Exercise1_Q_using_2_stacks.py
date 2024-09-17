# Time Complexity : Amortised TC : O(1), Worst case: O(n)
# Space Complexity : Amortised TC: O(1), Worst case: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def transfered_Required(self):
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())


    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        self.transfered_Required()
        return self.stack2.pop()
        

    def peek(self) -> int:
        self.transfered_Required()
        return self.stack2[len(self.stack2) - 1]
        

    def empty(self) -> bool:
        return len(self.stack1) == 0 and len(self.stack2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

