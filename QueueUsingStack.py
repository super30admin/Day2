#Time complexity of push operation is O(1)
#Time complexity of pop operation and peek opeartion is O(1) in average case and O(n) in the worst case
#Space complexity is O(n)



class MyQueue:

    def __init__(self):
        self.popStack = []
        self.appendStack = []

    def push(self, x: int) -> None:
        self.popStack.append(x)
        
    def QEmpty(self):
        if (self.appendStack == []):
            while(self.popStack != []):
                self.appendStack.append(self.popStack.pop())
        

    def pop(self) -> int:
        if len(self.popStack) == 1 and len(self.appendStack) == 0:
            return self.popStack.pop()
        self.QEmpty()
        return self.appendStack.pop()
           

    def peek(self) -> int:
        self.QEmpty()
        return self.appendStack[-1]
        

    def empty(self) -> bool:
        return len(self.popStack) + len(self.appendStack) == 0
