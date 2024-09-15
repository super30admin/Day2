"""
LC:232 Implement queue using two stack
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA
//Explaination: Used two stacks to implement queue-instk and outstk
If outstk is empy and operation is pop,transfer instk-->outstk
push in instk
pop,peek from outstk
"""

class MyQueue:
    def __init__(self):
      self.instk = []
      self.outstk = []
      self.length = 0

    def push(self, x: int) -> None:
        self.instk.append(x)

    def pop(self) -> int:
      if self.outstk:
        return self.outstk.pop()
      else:
        for _ in range(len(self.instk)):
          self.outstk.append(self.instk.pop())
        return self.outstk.pop()

    def peek(self) -> int:
        if self.outstk:
          return self.outstk[-1]
        else:
          for _ in range(len(self.instk)):
            self.outstk.append(self.instk.pop())

    def empty(self,stk) -> bool:
      return len(stk)

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
print("instk=",obj.instk,"outstk=",obj.outstk)
print("pop=",obj.pop())
print("instk=",obj.instk,"outstk=",obj.outstk)
print("peek:",obj.peek())
print("pop=",obj.pop())
print("instk=",obj.instk,"outstk=",obj.outstk)
obj.push(5)
obj.push(6)
print("instk=",obj.instk,"outstk=",obj.outstk)
print("peek:",obj.peek())
print("pop=",obj.pop())
print("instk=",obj.instk,"outstk=",obj.outstk)
