"232. Implement Queue using Stacks"
"""
Time Complexity: O(1)
Space Complexity: O(n)
"""

"""
- Create 2 empty stacks S1 and S2. For append operation, just push to the s1.
- For pop and peek, check if s2 is not empty, if s1 is empty then pop from s1 and append to s2 else return the top element in pop and peek. 
- Just compare the len to 0 for both stacks and return.
"""

class MyQueue:

    def __init__(self):
        #create 2 stacks(S1=IN and S2=OUT)
        self.s1 = []
        self.s2 = []
        

    def push(self, x: int) -> None:
        #append to the s1
        self.s1.append(x)

    def pop(self) -> int:
        #if s2 is not empty, pop the element else pop from s1 to s2 and then pop from s2
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
        

    def peek(self) -> int:
        #if s2 is empty return top of s2 else pop from s1 and append to s2, and return top
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        

    def empty(self) -> bool:
        return max(len(self.s1), len(self.s2)) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()