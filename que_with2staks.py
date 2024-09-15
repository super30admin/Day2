#time complexity: O(1) for push, empty and for pop and peek in normal cases but in worst case it is O(n) for pop()
#worst case for pop happens when we try to pop and instack is empty
#space complexity: O(2n) or O(n) because each element is taking up space
#passed all cases on LeetCode: yes
#difficulty faced: forgot else case in the peek case, it is pretty straightforward operation  
# comments: we maintain 2 stacks, always push in instack and pop from outstack. transfer from instack to outstack when outstack is empty and we are peeking or popping
#https://leetcode.com/problems/implement-queue-using-stacks/submissions/
class MyQueue:

    def __init__(self):
        #these both have integer elements
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop(-1)

    def peek(self) -> int:
        if not self.outstack:
            while (self.instack):
                self.outstack.append(self.instack.pop(-1))
                
        return self.outstack[-1]
        #should only return the element and not pop it here since it is peek        
        
            
            

    def empty(self) -> bool:
        return (not self.outstack and not self.instack)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()