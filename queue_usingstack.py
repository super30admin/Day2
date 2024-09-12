#Time Complexity = O(1) for push, pop,peek and empty
#Space Complexity = O(1) 
#Did your code run on leetcode: yes
#Approach : we are using two stacks in this approach while performing peek and pop operation check whether innerstack is empty or not 
#if not empty we push all the elements from innerstack to outer sstack and pop the topmost element from the outerstack as it is 
#the first elemnt entered in queue and for peek we return the topmost element from outerstack we donot pop it.

class MyQueue:

    def __init__(self):
        self.innerstack = []
        self.outerstack = []
        

    def push(self, x: int) -> None:
        self.innerstack.append(x)
        

    def pop(self) -> int:
        if len(self.outerstack) == 0:
            while(len(self.innerstack) != 0):
                self.outerstack.append(self.innerstack.pop())
        return self.outerstack.pop()


        

    def peek(self) -> int:
        if len(self.outerstack) == 0:
            while(len(self.innerstack) != 0):
                self.outerstack.append(self.innerstack.pop())
        return self.outerstack[-1]

    def empty(self) -> bool:
        return len(self.innerstack) == 0 and   len(self.outerstack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
