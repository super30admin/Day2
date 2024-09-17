// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import sys
class MinStack:
   

    def __init__(self):
        self.min=sys.maxsize
        self.st=[]

    def push(self, val: int) -> None:
        if self.min>= val:
            self.st.append(self.min)
            self.min=val
        self.st.append(val)

    def pop(self) -> None:
        if self.min == self.st.pop():
            self.min=self.st.pop()
            print (self.min)
        else:    
            self.st.pop()
        
    def top(self) -> int:
        return self.st[-1]
        
    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()