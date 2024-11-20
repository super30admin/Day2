# Time Complexity : O(n) - pop - worst case
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

  def __init__(self):
    self.push_stack = []
    self.pop_stack = []

  def push(self, x: int) -> None:
    self.push_stack.append(x)

  def pop(self) -> int:
    if not self.pop_stack:
      while self.push_stack:
        self.pop_stack.append(self.push_stack.pop(len(self.push_stack) - 1))        
    return self.pop_stack.pop(len(self.pop_stack) - 1)

  def peek(self) -> int:
    if not self.pop_stack:
      while self.push_stack:
        self.pop_stack.append(self.push_stack.pop(len(self.push_stack) - 1))
    return self.pop_stack[len(self.pop_stack) - 1]

  def empty(self) -> bool:
    return not self.push_stack and not self.pop_stack
        


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(4)
obj.push(7)
obj.push(9)
obj.push(1)
obj.push(5)
print(obj.push_stack)
print(obj.pop())

print(obj.pop())
print(obj.pop())
obj.push(10)
print(obj.peek())
print(obj.pop())
print(obj.pop())
print(obj.pop())
print(obj.empty())