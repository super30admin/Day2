# Time Complexity : on average is O(1) & worst case scenario it's O(n) 
# Space Complexity : is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None, although I want to optimize the function even further


# Your code here along with comments explaining your approach   
# take 2 lists and use one named ins to push the elements into and use the other named out for operations of peek and pop
# whenever the out list is empty and either peek or pop is called transfer all items from ins to out and return the resulted values

class MyQueue:

    def __init__(self):
        self.ins = list()
        self.out = list()

    def push(self, x: int) -> None:
        self.ins.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out.pop()

    def peek(self) -> int:
        if not self.out:
            while self.ins:
                self.out.append(self.ins.pop())
        return self.out[-1]

    def empty(self) -> bool:
        return not self.ins and not self.out


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()