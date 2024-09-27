class MyQueue:
  
  def __init__(self):
    self.l1 = list()
    self.l2 = list()

  def push(self, x: int) -> None:
    self.l1.append(x)

  def pop(self) -> int:
    self.peek()
    return self.l2.pop()

  def peek(self) -> int:
    if(not len(self.l2)):
        while(len(self.l1)):
            self.l2.append(self.l1.pop())
    return self.l2[-1]

  def empty(self) -> bool:
    return not len(self.l1) and not len(self.l2)




# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
