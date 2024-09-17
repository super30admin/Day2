# Time Complexity : for push O(1); for pop O(n) ; for peek O(1) ; for empty O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        while(len(self.stack1)!=1):
            self.stack2.append(self.stack1.pop())
        pop_element = self.stack1.pop()
        while(len(self.stack2) != 0 ):
            self.stack1.append(self.stack2.pop())
        return pop_element
        

    def peek(self) -> int:
        return self.stack1[0]
        

    def empty(self) -> bool:
        if(len(self.stack1) ==0):
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()