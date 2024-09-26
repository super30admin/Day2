#Implement Queue using stacks
#SC: O(N)
#TC: O(1)

class MyQueue:

    def __init__(self):
        self.s1 = [] #instack
        self.s2= [] #outstack
        

    def push(self, x: int) -> None:
        self.s1.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.s2.pop()

    def peek(self) -> int:
        if len(self.s2)==0:
            while len(self.s1)!=0:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        

    def empty(self) -> bool:
        return (not self.s1) and (not self.s2)
        

