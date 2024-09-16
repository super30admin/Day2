#Solution 1
'''
// Time Complexity : Push O(N) Pop O(1)
// Space Complexity : O(N)  where N is Number of buckets + Number of unique values
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :    Found issue to arrive the logic

// Your code here along with comments explaining your approach

This approach uses two stacks main and secondary
    push: put main stack into secondary upside down, push new element and transfer back from secondary
    pop : Just pop top element
    peek : return top element

Eg: 
push(4)
push(5)
push(6)
    In a list [4,5,6]
 
 Stack view    
    |6|     | |
    |5| =>  | |
    |4|     | |
    ___     ___
    S1      S2
 
 Stack view    
    | |     |4|
    | | =>  |5|
    | |     |6|
    ___     ___
    S1      S2

Solution :
    push(7)
Stack view    
    | |     |4|
    | | =>  |5|
    |7|     |6|
    ___     ___
    S1      S2



https://leetcode.com/problems/implement-queue-using-stacks/
'''


class MyQueue:

    def __init__(self):
        self.st1=[]
        self.st2=[]

    def push(self, x: int) -> None:
        while self.st1:
            self.st2.append(self.st1.pop())
        self.st2.append(x)
        while self.st2:
            self.st1.append(self.st2.pop())

    def pop(self) -> int:
        if self.st1:
            return self.st1.pop()
        else:
            return None

    def peek(self) -> int:
        if self.st1:
            return self.st1[-1]

    def empty(self) -> bool:
        if self.st1:
            return False
        return True





# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
