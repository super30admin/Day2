#LC: 232: Design Queue
## Implemented Queue 
## So there are multiple ways of implementing Queue here for average case of 0(1) and worst case can be o(N) for pop()
## what we are doing here that we are taking two stacks as in and out and when push operation called we are implementing append in stack 
## if pop is called then checking that out stack is empty if yes then poping the data from in and pushing to the out till the time in will get empty 
## Then using pop removing the first element and in peek doing the almost same just not removing the element it's just printing the element 
## empty : if both lists are empty then empty(self) will return empty

## Passed in LeetCode

class MyQueue:

    def __init__(self):
        self.inlist = []
        self.outlist = []

    def push(self, x: int) -> None:
        self.inlist.append(x)
        return self.stPush
        

    def pop(self) -> int:
        if self.outlist == []:
            while self.inlist != []:
                self.outlist.append(self.inlist.pop())
        return self.outlist.pop()

    def peek(self) -> int:
        if self.outlist == []:
            while self.inlist != []:
                self.outlist.append(self.inlist.pop())
        return self.outlist[-1]

    def empty(self) -> bool:
        if self.inlist == [] and self.outlist == []:
            return True
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

