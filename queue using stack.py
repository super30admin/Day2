#Time Complexity = O(1)
#Space Complexity = O(n)
#Ran successfully on LC
#No problems were faced as such

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.front = None #pointer to first element

    def push(self, x: int) -> None:
        if not self.stack1:
            self.front = x #points to first element in stack 1
        self.stack1.append(x)

    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop()) #pop from stack 1 and insert in stack 2
        ans = self.stack2.pop() #first element of stack 1
        return ans

    def peek(self) -> int:
        if self.stack2:
            return self.stack2[-1] #last element of stack 2
        return self.front #if stack 2 empty return first element of stack 1

    def empty(self) -> bool:
        return (not self.stack1 and not self.stack2) #stack empty conditions
