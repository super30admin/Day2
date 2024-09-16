"""
The time complexity of push is O(1), for pop the best achivable is O(1), while the
worst scenario is O(n), but on an avg the amortized complexity is O(1), same for peek operation.
empty operation is constant time.

Space complexity is O(n)

"""
class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        if len(self.out_stack) == 0:
            stop = len(self.in_stack)
            for i in range(0, stop):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        if len(self.out_stack) == 0:
            stop = len(self.in_stack)
            for i in range(0, stop):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        if len(self.in_stack) == 0 and len(self.out_stack) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
