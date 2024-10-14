class MyQueue:

    def __init__(self):
        self.inSTACK = []
        self.outSTACK = []
    def push(self, x: int) -> None:
      self.inSTACK.append(x)
        
    def pop(self) -> int:
      self.peek()
      return self.outSTACK.pop()
        

    def peek(self) -> int:
      if len(self.outSTACK) == 0:
        while (len(self.inSTACK)) >0:
          self.outSTACK.append((self.inSTACK.pop()))
          
      return self.outSTACK[-1]

        

    def empty(self) -> bool:
      if (len(self.inSTACK) ==0) and (len(self.outSTACK)== 0):
        return True
      else: 
        return False
        