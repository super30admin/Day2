#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :  Yes
#Any problem you faced while coding this : had a problem with pop operating but found an edge case where if you are popping you need to pop everything from stack1 and then push into stack 2


#Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.stack1=[]
        self.stack2=[]

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
    def empty(self) -> bool:
        return (not self.stack1 and not self.stack2)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()