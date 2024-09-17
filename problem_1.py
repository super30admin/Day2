"""
Python implementation of Queue using 2 stacks
Time complexity for push,pop,peek,isempty  : O(1)
Space Complexity  for 2 stacks : O(N) where N is the no. of elements inserted in the queue 
""" 

class MyQueue:
    def __init__(self):
        self.instack = [] 
        self.outstack = []

    def push(self, x: int) -> None:
        #Push element x to the back of queue.
        self.instack.append(x)                

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()    
        

    def peek(self) -> int:
        if self.outstack == []:
            while self.instack != []:
                self.outstack.append(self.instack.pop())
        
        return self.outstack[-1]        

    def empty(self) -> bool:

        return not self.instack and not self.outstack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()