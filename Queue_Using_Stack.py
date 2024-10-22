#Impelemnted queue using 2 stacks
#Such, that one will act as normal stack and the the other will be store the values
# of the stack in reverse order

class MyQueue:

    def __init__(self):
        self.hqueue  = []
        self.tqueue = []

    def push(self, x: int) -> None:
        self.hqueue.append(x)    

    def pop(self) -> int:
        if not self.tqueue:
            while self.hqueue:
                self.tqueue.append(self.hqueue.pop())
        x = self.tqueue.pop()
        return x
        
    def peek(self) -> int:
        if self.tqueue:
            return self.tqueue[-1]
        else:
            return self.hqueue[0]

    def empty(self) -> bool:
        if not self.hqueue and not self.tqueue:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()