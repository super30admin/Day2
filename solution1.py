# Time Complexity : push -> O(1), pop -> amortized O(1) , peek -> O(1), empty -> O(1)
# Space Complexity : push -> O(n), pop -> O(1) , peek -> O(1), empty -> O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        
        self.s1=[]
        # to return front entry
        self.s2=[]
        # used when s2 is empty
        self.front=None
        

    def push(self, x: int) -> None:
        
        if not self.s1:
            self.front=x
        self.s1.append(x)
        
        
        

    def pop(self) -> int:
        # transfer entries from s1 to s2 to imitate queue pop
        if len(self.s2)==0:
            while len(self.s1)!=0:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
        
        

    def peek(self) -> int:
        # returns front element 
        if self.s2:
            return self.s2[-1]
        return self.front
        
        

    def empty(self) -> bool:
        # check both
        return not self.s1 and not self.s2