#Time complexity: pop, peek - O(n);empty, push - O(1)
#Space complexity: O(n)
#Leetcode: Yes

class MyQueue:

    def __init__(self):
        self.inQueue = []
        self.outQueue = []
    
    def transfer(self):
        for i in range(len(self.inQueue)-1,-1,-1):
            self.outQueue.append(self.inQueue[i])
        self.inQueue.clear()

    def push(self, x: int) -> None:
        self.inQueue.append(x)

    def pop(self) -> int:
        if len(self.outQueue) != 0:
            temp = self.outQueue[-1]
            self.outQueue.remove(self.outQueue[-1])
            return temp
        elif len(self.outQueue) == 0 and len(self.inQueue) != 0:
            self.transfer()
            temp = self.outQueue[-1]
            self.outQueue.remove(self.outQueue[-1])
            return temp
        else:
            return "null"


    def peek(self) -> int:
        if len(self.inQueue) == 0 and len(self.outQueue) == 0:
            return "null"
        elif len(self.inQueue) != 0 and len(self.outQueue) == 0:
            self.transfer()
            return self.outQueue[-1]
        else:
            return self.outQueue[-1]

    def empty(self) -> bool:
        if len(self.inQueue) == 0 and len(self.outQueue) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()