# Time: O(1)
# Space: O(n)
# Executed successfully on Leetcode (after the class session)
# No challenges faced

class MyQueue:
    def __init__(self):
        self.inn = []
        self.out = []
        

    def push(self, x: int) -> None:
        self.inn.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.out.pop()
        

    def peek(self) -> int:
        if not self.out:
            while(self.inn != []):
                self.out.append(self.inn.pop())
        return self.out[-1]
        

    def empty(self) -> bool:
        return len(self.inn) == 0 and len(self.out) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()