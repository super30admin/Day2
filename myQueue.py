#Time complexity: O(1)
#Space complexity for pop: O(n), remaining all operations : O(1)
# This code successfully ran on leetcode
class MyQueue:

    def __init__(self):
        self.queue=[] #initializing fifo 
        self.count=0

    def push(self, x: int) -> None:
        self.queue.append(x)
        self.count+=1

    def pop(self) -> int:
        if len(self.queue)>0:
            self.count-=1
            return self.queue.pop(0) #popping from the first index

    def peek(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return self.count==0
                


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()