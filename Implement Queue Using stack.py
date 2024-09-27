// Time Complexity : O(1) for push,pop,peek and empty operations.
 // Space Complexity : O(n)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.q1 = []
        self.q2 = []
        

    def push(self, x: int) -> None:
        self.q1.append(x)
        
    def pop(self) -> int:
        self.peek()

        return self.q2.pop()

    def peek(self) -> int:
        if not self.q1:
            while(self.q1):
                self.q2.append(self.q1.pop())
       
                
                
  
        return self.q2[-1]

    def empty(self) -> bool:
        if ((len(self.q1)==0) and (len(self.q2)==0)):
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()