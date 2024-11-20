# Time Complexity: Amortized O(1) Sometimes to empty the PushStack it takes O(n), but it happens only few times
# Space Complexity: O(2n)
# Did code run on Leetcode: Yes
# Approach: I maintain 2 stacks in this case. One the push stack, the other pop stack. Stacks have a good property that when we pop out all
# elements, the elements are reversed.
# I used this property. All elements are pushed into the pushStack. To pop, if the pop stack is empty, we empty all elements from pushStack
# Then pop/peek operations can be done from the popStack

from collections import deque


class MyQueue:
    def __init__(self):
        self.pushStack = deque()
        self.popStack = deque()

    def push(self, x: int) -> None:
        self.pushStack.append(x)

    def pop(self) -> int:

        self.peek()
        return self.popStack.pop()

    def peek(self) -> int:
        if not (self.popStack):
            while not (self.pushStack):
                self.popStack.append(self.pushStack.pop())
        return self.popStack[-1]

    def empty(self) -> bool:
        return len(self.pushStack) == 0 and len(self.popStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
