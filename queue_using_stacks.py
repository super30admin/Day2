"""
- Problem: Implement queue using stacks (https://leetcode.com/problems/implement-queue-using-stacks/)
    - push(x) -- Push element x to the back of queue.
    - pop() -- Removes the element from in front of queue.
    - peek() -- Get the front element.
    - empty() -- Return whether the queue is empty.
- Time Complexity: mentioned in code functions
- Space Complexity: mentioned in code functions
"""


class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.st1 = []
        self.st2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        Time complexity : O(1). Аppending an element to a stack is an O(1) operation.
        Space complexity : O(n). We need additional memory to store the queue elements
        """
        self.st1.append(x)
        print("Pushed: ", x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        Time complexity: Amortized O(1), Worst-case O(n).
        Amortized because we only need to transfer numbers from stack1 to stack2 when stack 2 is empty.
        Space complexity : O(1).
        """
        if len(self.st2) == 0:
            while len(self.st1) != 0:
                self.st2.append(self.st1.pop())
        if len(self.st2) == 0:
            return -1
        popped = self.st2.pop()
        print("Popped: ", popped)

    def peek(self) -> int:
        """
        Get the front element.
        Time complexity: Amortized O(1), Worst-case O(n).
        Amortized because we only need to transfer numbers from stack1 to stack2 when stack 2 is empty.
        Space complexity : O(1).
        """
        if len(self.st2) == 0:
            # Move all elements of stack1 to stack2
            while len(self.st1) != 0:
                self.st2.append(self.st1.pop())
        if len(self.st2) == 0:
            return -1
        peeked = self.st2[-1]
        print("Peeked: ", peeked)

    def empty(self) -> None:
        """
        Returns whether the queue is empty.
        Time complexity : O(1).
        Space complexity : O(1).
        """
        if len(self.st1) == 0 and len(self.st2) == 0:
            print("Queue is empty")
        else:
            print("Queue not empty")


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.pop()
obj.peek()
obj.empty()
obj.push(5)
obj.pop()
obj.pop()
obj.pop()
obj.pop()
obj.empty()


