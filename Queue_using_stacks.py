class stack:
    def __init__(self):
        self.a=[]
    def push(self,a):
        self.a.append(a)

    def pop(self):
        return self.a.pop()

    def peek(self):
        if not self.isEmpty():
            return self.a[-1]

    def isEmpty(self):
        if len(self.a) == 0:
            return True
        else:
            return False

class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.first=stack()
        self.second=stack()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if self.first.isEmpty():
            self.transfer()
        self.first.push(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.empty():
            if self.second.isEmpty():
                self.transfer()
            return self.second.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.empty():
            if self.second.isEmpty():
                self.transfer()
            return self.second.peek()

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.first.isEmpty() and self.second.isEmpty():
            return  True
        else:
            return False

    def transfer(self):
        if not self.empty():
            if self.first.isEmpty():
                # second to first
                while not self.second.isEmpty():
                    self.first.push(self.second.pop())
            else:
                # first to second
                while not self.first.isEmpty():
                    self.second.push(self.first.pop())

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(4)
obj.push(2)
obj.push(5)
obj.push(8)
print(obj.pop())
print(obj.peek())
print(obj.empty())

