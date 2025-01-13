"""
  https://leetcode.com/problems/implement-queue-using-stacks/description/
  leetcode #232: Implement queue using stack
"""


"""
Approach 1: In this approach I will be creating 2 stacks ( inStack and outStack). Push happens in inStack and pop and peek happens on outStack. However, before pop or peek I will transfer all the elements from inStack to Outstack befor pop
Operational algorithm:
push : O(1) constant time require to push elements in inStack
peek / pop : O(N) first transfer all alaments from inStack to outStack and then in contsant time pop the element or peek
"""


class MyQueueApproach1:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def transferInStackOutStack(self) -> None:
        # method to transfer all the elemnts from inStack to outStack
        while self.inStack:
            self.outStack.append(self.inStack.pop())

    def transferOutStackInStack(self) -> None:
        # method to transfer all the elemnts from inStack to outStack
        while self.outStack:
            self.inStack.append(self.outStack.pop())

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        # if stack is empty then return -1
        if self.empty():
            return -1
        # first transfer all elements
        self.transferInStackOutStack()

        # then pop from outStack
        poped_element = self.outStack.pop()

        # transfer again
        self.transferOutStackInStack()

        return poped_element

    def peek(self) -> int:
        # if stack is empty then return -1
        if self.empty():
            return None
        # first transfer all elements
        self.transferInStackOutStack()

        # then pop from outStack
        top_element = self.outStack[-1]

        # transfer again
        self.transferOutStackInStack()

        return top_element

    def empty(self) -> bool:
        return not self.inStack and not self.outStack


"""
Approach 2: In this approach I will be creating 2 stacks ( inStack and outStack). Push happens in outStack and pop and peek happens on inStack. However, every time we push I will transfer all the elemnts from inStack to OutStack and then do push in O(1) time in outStack and then transfer back to inStack, so that when we want to pop elements inStak is with correct element at the top.
Operational algorithm:
push : first transfer elements from inStack to OutSTack in O(N) then do push on outStack O(1) and then transfer back to inStack O(N)
peek / pop : O(1) from inStack.
"""


class MyQueueApproach2:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def transferInStackOutStack(self) -> None:
        # method to transfer all the elemnts from inStack to outStack
        while self.inStack:
            self.outStack.append(self.inStack.pop())

    def transferOutStackInStack(self) -> None:
        # method to transfer all the elemnts from inStack to outStack
        while self.outStack:
            self.inStack.append(self.outStack.pop())

    def push(self, x: int) -> None:
        if self.empty():
            # if stack is empty then just push element in inStack
            self.inStack.append(x)
        else:
            # stack has some data
            # first transfer data from inStack to outStack
            self.transferInStackOutStack()

            # perfom push operation on outStack
            self.outStack.append(x)

            # transfer back
            self.transferOutStackInStack()

    def pop(self) -> int:

        # if stack is empty then return -1
        if self.empty():
            return None

        # pop the element from inStack
        return self.inStack.pop()

    def peek(self) -> int:
        # if stack is empty then return -1
        if self.empty():
            return None

        # return the top most element of inStack
        return self.inStack[-1]

    def empty(self) -> bool:
        return not self.inStack and not self.outStack


"""
Approach 3: The intuition behind this approach is to optimize the first approach. In the first approach, during the first pop operation, we transfer all elements from inStack to outStack, perform the pop operation on outStack, and then transfer the elements back to inStack. However, instead of transferring the elements back to inStack, we can keep them in outStack. If another pop operation occurs, we can directly pop from outStack.
This saves us one transfer operation (O(N)), and after the first pop, outStack will contain all the elements pushed so far. Consequently, subsequent pop operations after the first one are performed in O(1) time.
Push: O(1)
pop / peek: Avarange O(1)
"""


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def transferInStackOutStack(self) -> None:
        # method to transfer all the elemnts from inStack to outStack
        while self.inStack:
            self.outStack.append(self.inStack.pop())

    def push(self, x: int) -> None:
        # always push in inStack
        self.inStack.append(x)

    def pop(self) -> int:
        # check if empty
        if self.empty():
            return None

        if not self.outStack:
            # transfer
            self.transferInStackOutStack()

        # simply pop from outstrack
        return self.outStack.pop()

    def peek(self) -> int:
        # check if empty
        if self.empty():
            return None

        if not self.outStack:
            # transfer
            self.transferInStackOutStack()

        # simply pop from outstrack
        return self.outStack[-1]

    def empty(self) -> bool:
        return not self.inStack and not self.outStack
