'''
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
class MyQueue:

    def __init__(self):
        
        self.outArr = []
        self.inArr = []
        
    def push(self, x: int) -> None:
        self.inArr.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outArr.pop()
        

    def peek(self) -> int:
        if(len(self.outArr)==0):
            while(len(self.inArr)!=0):
                self.outArr.append(self.inArr.pop())
                
        return self.outArr[-1]
        

    def empty(self) -> bool:
        return (len(self.inArr)==0) and (len(self.outArr)==0)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()