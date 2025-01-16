# Time complexity -
#     push() - O(n)
#     pop() - O(1)
#     peek() - O(1)
#     empty() - O(1)

# Space complexity - O(n)

# Approach - Since queue is FIFO, but stack is LIFO, maintain two stacks, so you can reverse the
# stack. All the other operations are then simplified

class MyQueue:

    def __init__(self):
        self.st1 = []
        self.st2 = []   

    def push(self, x: int) -> None:
        while self.st1:
            self.st2.append(self.st1.pop())
        self.st1.append(x)
        while self.st2:
            self.st1.append(self.st2.pop())

    def pop(self) -> int:
        return self.st1.pop()

    def peek(self) -> int:
        return self.st1[-1]
        
    def empty(self) -> bool:
        if len(self.st1) == 0:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()