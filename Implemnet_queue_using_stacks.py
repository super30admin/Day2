
#Time Complexity :- O(1) for push,pop,empty
#Space Complexity :- O(n)
# This implementation uses two stacks: `inn` for adding elements and `out` for removing or peeking elements. 
# Elements are moved from `inn` to `out` only when `out` is empty, ensuring efficient \(O(1)\) amortized time for `pop` and `peek` operations. 
# Did this code successfully run on Leetcode  :- yes 

class MyQueue:

    def __init__(self):
        self.inn = []
        self.out = []
        
    def push(self, x: int) -> None:
        self.inn.append(x)
    def pop(self) -> int:
        if not self.out:
            while self.inn:
                self.out.append(self.inn.pop())
        return self.out.pop()
    def peek(self) -> int:
        if not self.out:
            while self.inn:
                self.out.append(self.inn.pop())
        return self.out[-1]
        
    def empty(self) -> bool:
        return max(len(self.inn),len(self.out)) == 0
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()