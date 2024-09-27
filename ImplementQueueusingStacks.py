# Time Complexity : O(1) best and worst Time Complexity for Push and Empty
                  # O(1) best Time Complexity and O(n) worst Time Complexity for Peek and Pop
# Space Complexity : O(1) for Push and Empty and O(n) for Peek and Pop
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        self.stack1.append(x)

    def pop(self):
        if len(self.stack2) == 0:
            self.transfer()
        return self.stack2.pop()

    def peek(self):
        if len(self.stack2) == 0:
            self.transfer()
        return self.stack2[-1]

    def empty(self):
        return (len(self.stack1) == 0 and len(self.stack2) == 0)
    
    def transfer(self):
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()