#Time Complexity = O(1)
#Space Complexity = O(n)
# Successfully compiled and run on Leetcode

class MyQueue:

    def __init__(self):
        self.pushstk = [] #create push stack
        self.popstk = [] #create pop stack

    def push(self, x: int) -> None:
        self.pushstk.append(x) # push val on push stack when enqueue is performed

    def pop(self) -> int:
        if len(self.popstk) == 0: #first check if pop stack is empty
            while self.pushstk: # loop over val stored in push stack - to store them into pop stack
                self.popstk.append(self.pushstk.pop())
        return self.popstk.pop() # popped val should be the first element when dequeue is performed

    def peek(self) -> int:
        if len(self.popstk) != 0: # if popstack is not empty then first top element should be returned from popstack
            return self.popstk[-1]
        else:
            return self.pushstk[0] #else from push stack - because no dequeue operation was performed

    def empty(self) -> bool:
        return len(self.pushstk) == 0 and len(self.popstk) == 0 # if both popstack and pushstack are empty then queue is all processed or empty

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()