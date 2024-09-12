# Time complexity: O(1) average, O(n) in worst case
# Space Complexity: O(n)
# Ran on leetcode: Yes

class MyQueue:

    def __init__(self):
        
        self.inp = []
        self.out = []
        """
        Initialize your data structure here.
        """
        
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inp.append(x)
        
    def move(self):
        for i in range(len(self.inp)):
            self.out.append(self.inp.pop())
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not len(self.out):
            self.move()
        return self.out.pop()
    

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not len(self.out):
            self.move()
        return self.out[-1]
                
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not len(self.inp) and not len(self.out))
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()