# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        #Inititalise two stacks
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        #Pushing the element into first stack
        self.s1.append(x)

    def pop(self) -> int:
        #Check if second stack is empty
        if not self.s2:
            #If yes, then until first stack is empty pop each element and push into second stack
            while self.s1:
                self.s2.append(self.s1.pop())
        #Pop from second stack as it will be the first element pushed and poped in terms of a queue
        return self.s2.pop()
    
    def peek(self) -> int:
        #Similar concept as pop refer to those comments
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
    def empty(self) -> bool:
        #To check if the length is 0 then return True or False
        if (len(self.s1)==0 and len(self.s2)==0):
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
