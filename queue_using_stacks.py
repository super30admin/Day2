"Time Complexity is O(1) on average since, we will be iterating through first stack and appending the second stack once in a while, and other operations are anyway O(1)"
"Space Complexity is O(N) as we will be using two stacks of the size of N"

#Explanation

"We will be using two stacks, one instack and one outstack"
"We keep pushing elements as we get into instack"
"When the operation is pop or peek, we first check if there are no elements in the outstack and then if it is empty, we append all the elements from the instack into the outstack"
"Pop or peek, we always give the latest element added into the out stack and it explains the first element added into the instack"

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if len(self.outstack) == 0:
            while len(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        
        return self.outstack.pop()

    def peek(self) -> int:
        if len(self.outstack) == 0:
            while len(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self) -> bool:
        return len(self.instack) == 0 and len(self.outstack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()