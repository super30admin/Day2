"""
Time complexity O(1) for Push, Pop, peek and empty
Space Complexity O(1)


Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this : No

"""
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1=[]
        self.s2=[]

    def push(self, x: int) -> None:
        self.s1.append(x) 
        

    def pop(self) -> int:
        """
        do peek and pop the top element 
        """
        self.peek()
        return self.s2.pop()
        
    
    def peek(self) -> int:
        """
        if s2 is empty remove ele from s1 and append to s2
        then return last elem of s2 
        """
        if len(self.s2)== 0:
            while self.s1:
                self.s2.append(self.s1.pop())

        return self.s2[-1]
        

    def empty(self) -> bool:
        return not self.s1 and not self.s2
            


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()