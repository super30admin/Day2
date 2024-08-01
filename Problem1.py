# // Time Complexity : O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        # initiated 2 stacks
        self.instack = []
        self.outstack = []
        
    def push(self, x: int) -> None:
        # append to the in stack
        self.instack.append(x)

    def pop(self) -> int:
        # take care of populating outstack if empty then pop
        self.peek()
        return self.outstack.pop()

    def peek(self) -> int:
        # checked if outstack is empty.
        # if it is then transfer all the instack elements to outstack
        # then return last element
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        if self.outstack:
            return self.outstack[-1]

    def empty(self) -> bool:
        # if both instack and outstack are empty then return true else false
        if not self.instack and not self.outstack:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()