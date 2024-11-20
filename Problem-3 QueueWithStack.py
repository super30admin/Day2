# Time Complexity: 
# Push: O(1)
# Pop: O(n)
# Peep: O(n)

# Space Complexity: O(n)

class MyQueue:

    def __init__(self):
        self.head = []
        self.tail = []

    def push(self, x: int) -> None:
        self.head.append(x)
        
    def _shifter(self, source, dest):
        while source:
            dest.append(source.pop())
        return source, dest
    
    def pop(self) -> int:
        if not self.empty():
            self.head, self.tail = self._shifter(self.head, self.tail)
            popped = self.tail.pop()
            self.tail, self.head = self._shifter(self.tail, self.head)
            return popped

    def peek(self) -> int:
        if not self.empty():
            self.head, self.tail = self._shifter(self.head, self.tail)
            top = self.tail[-1]
            self.tail, self.head = self._shifter(self.tail, self.head)
            return top

    def empty(self) -> bool:
        return len(self.head) == 0

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
# obj.push(4)
# print(obj.head, obj.tail)
param_2 = obj.pop()
param_2 = obj.pop()
print(obj.peek())
print(obj.empty())