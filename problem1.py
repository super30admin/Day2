'''
Time Complexity :
  push: O(1)
  pop: O(n) in worst case
  peek: O(n) in worst case
  empty : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach

'''

class MyQueue:

  def __init__(self):
    self.pushStack = []
    self.popStack = []

  # push on top of pushStack
  def push(self, x: int) -> None:
    self.pushStack.append(x)

  # if popStack is empty, pop all elements from pushStack and push them in popStack
  # this way their sequence is reversed and the first pushed element is now on the top of the popStack
  # then pop from the top of popStack
  def pop(self) -> int:
    if len(self.popStack) == 0:
      while len(self.pushStack) > 0:
        self.popStack.append(self.pushStack.pop())
    if len(self.popStack) > 0:
      return self.popStack.pop()

  # if popStack is empty, pop all elements from pushStack and push them in popStack
  # this way their sequence is reversed and the first pushed element is now on the top of the popStack
  # then peek from the top of popStack
  def peek(self) -> int:
    if len(self.popStack) == 0:
      while len(self.pushStack) > 0:
        self.popStack.append(self.pushStack.pop())
    if len(self.popStack) > 0:
      return self.popStack[-1]

  # queue is empty if both the stacks are empty
  def empty(self) -> bool:
    return len(self.pushStack) == len(self.popStack) == 0


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()

print('Push 7')
obj.push(7)

print('Push 3')
obj.push(3)

print('Push 4')
obj.push(4)

print('Push 5')
obj.push(5)

print('pop():', obj.pop())

print('Push 4')
obj.push(4)

print('Push 8')
obj.push(8)

print('pop():', obj.pop())
print('pop():', obj.pop())
print('pop():', obj.pop())
print('pop():', obj.pop())
print('pop():', obj.pop())
