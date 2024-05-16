# Time Complexity :

# push: O(1)
# pop: avg case : O(1), worst case : O(n)
# peek: O(1)
# empty: O(1)


# space complexity : O(n)

# Approach :

# 2 stacks are used in stack and out stack
# while pushing , keep pushing the element in the instack
# while popping, check if stack is empty, if empty transfer the entire instack to the outstack and perform pop on the outstack, if not empty, just pop the top element without transferring


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:

        self.inStack.append(x)

    def pop(self) -> int:

        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:

        if not self.outStack:
            return self.inStack[0]
        else:
            return self.outStack[-1]

    def empty(self) -> bool:

        if not self.inStack and not self.outStack:
            return True
        else:
            return False
