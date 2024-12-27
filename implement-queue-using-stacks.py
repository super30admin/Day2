#Using 2 stacks and pushed in stack 1. For pop transferred all the element to 2nd stack which will ahve last in elements as first and popped from there until empty
#This is amortized O(1) time complexity since all the elements are pushed once over the lifetime divided over miltiple steps
#Space complexity is O(n) since we used 2 stacks

#Yes this worked in Leetcode

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        return not self.stack1 and not self.stack2