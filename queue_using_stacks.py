class MyQueue:

    def __init__(self):
        self.instack = []    #initialize the in stack
        self.outstack = []   #initialize the out stack

    def push(self, x: int) -> None:
        self.instack.append(x)  #insert the values into the instack first

    def pop(self) -> int:
        if not self.outstack:    #if outstack is empty, then pop the elements from the instack and then append them to outstack
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()  #now pop the element from outstack in O(1)

    def peek(self) -> int:
        if not self.outstack: #if outstack is empty, then pop the elements from the instack and then append them to outstack
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1] #now peek the element from outstack in O(1)

    def empty(self) -> bool:
        return len(self.instack) == 0 and len(self.outstack) == 0 #if both instack and outstack are empty, then length will be eventualy zero