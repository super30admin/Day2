class MyQueue:

    def __init__(self):
        self.arr = []

    def push(self, x: int) -> None:
        self.arr.append(x)
 #pop function if value is there then pop
    def pop(self) -> int:
        val = self.arr[0]
        del self.arr[0]
        return val
       #peek element if present (to check)
    def peek(self) -> int:
        return self.arr[0]
     
  #check stack empty or not
    def empty(self) -> bool:
        if not len(self.arr):
               return True
        else:
               return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()