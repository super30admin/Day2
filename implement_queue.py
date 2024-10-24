# The code defines a queue using two stacks, s1 and s2, to simulate standard queue operations using only stack operations.
# Stack s1 is used for the enqueue operation, where elements are added as they come. Stack s2 is used for the dequeue operations.
# The push method appends an element to the end of stack s1, which holds elements in the order they are pushed.
# The pop method transfers elements from s1 to s2 (if s2 is empty) so that elements can be popped in FIFO order from s2, simulating a queue's dequeue operation.
# The peek method operates similarly to pop but returns the element at the front without removing it, ensuring elements are returned in FIFO order.
# The empty method checks whether both stacks are empty, returning True if they are, indicating that the queue is empty.
# TC: 
#   - Push: O(1), 
#   - Pop: Amortized O(1), worst-case O(n) when transferring from s1 to s2,
#   - Peek: Amortized O(1), worst-case O(n) when transferring from s1 to s2,
#   - Empty: O(1)
# SC: O(n) where n is the number of elements in the queue.


class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()

    def peek(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    def empty(self) -> bool:
        return max(len(self.s1), len(self.s2)) == 0