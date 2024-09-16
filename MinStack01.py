'''
// Time Complexity : Push O(1), 
// Space Complexity : Worst O(n), Best O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Had to consider empty array to pass all the cases on


// Your code here along with comments explaining your approach
'''

class MinStack:

    def __init__(self):
        self.items = []
        self.minitems = []
        
    def push(self, val: int) -> None:
        self.items.append(val)
        if self.minitems:
            self.minitems.append(min(val, self.minitems[-1]))
        else:
            self.minitems.append(val)
        
    def pop(self) -> None:
        self.items.pop()
        self.minitems.pop()
        
    def top(self) -> int:
        return self.items[-1]
       
    def getMin(self) -> int:
        return self.minitems[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()