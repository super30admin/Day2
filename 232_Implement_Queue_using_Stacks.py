// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack= []

    def push(self, x: int) -> None:
        self.in_stack.append(x)
        

    def pop(self) -> int:
        if not (self.out_stack):
            if not (self.in_stack):
                return 
            else:
                while (self.in_stack):
                    self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        if not (self.out_stack):
            if not (self.in_stack):
                return 
            else:
                while (self.in_stack):
                    self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]
        

    def empty(self) -> bool:
        if (len(self.out_stack) == 0) and (len(self.in_stack) == 0):
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
