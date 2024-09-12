class MyQueue:

    def __init__(self):
        self.in_l=[]
        self.out=[]
#Time Complexity: O(1)
#space complexity: O(1)
    def push(self, x: int) -> None:
        self.in_l.append(x)
#Time Complexity: O(1)
#space complexity: O(1)
    def pop(self) -> int:
        self.peek()
        return self.out.pop()
 #Time Complexity: O(1)
#space complexity: O(1)       
    def peek(self) -> int:
        if not self.out:
            while self.in_l:
                self.out.append(self.in_l.pop())
        return self.out[-1]
#Time Complexity: O(1)
#space complexity: O(1)
    def empty(self) -> bool:
        if not self.in_l and not self.out:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()