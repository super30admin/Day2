'''
- Test cases passed on leetcode
'''
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
    #O(1) Time complexity; O(1) space complexity
        self.stack1.append(x)
        

    def pop(self) -> int:
    # O(1) Time complexity; O(N) Space complexity
        if len(self.stack2) == 0:
            while (len(self.stack1) > 0):
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()
        

    def peek(self) -> int:
    #O(1) Time Complexity;O(N) space complexity
        if (len(self.stack2) == 0):
            while (len(self.stack1) > 0):
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        
        

    def empty(self) -> bool:
    #O(1) Time complexity; O(1) Space Complexity
         return (len(self.stack1) == 0 and len(self.stack2) == 0)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
