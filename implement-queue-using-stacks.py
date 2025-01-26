# Approach:
# The class uses two stacks (s1 and s2) to simulate a queue. 
# For every push, elements are moved to s2, the new element is added to s1, 
# and elements are moved back to maintain queue order.

# Time Complexity:
# push:O(n), where 𝑛 is the number of elements in s1 (due to transfers).
# pop, peek, empty: O(1).
# Space Complexity: O(n), where n is the number of elements in the queue.
class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        while self.s1:
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        return self.s1.pop()

    def peek(self) -> int:
        return self.s1[-1]

    def empty(self) -> bool:
        return not self.s1


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()