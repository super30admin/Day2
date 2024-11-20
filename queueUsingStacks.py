#Time Complexity : push - O(1), pop - O(n) (worst case)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes, 28 ms
#Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = []
        self.popStack= []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.popStack != []:
            popped = self.popStack.pop()
            return popped
        else:
            if self.pushStack != []:
                while self.pushStack != []:
                    self.popStack.append(self.pushStack.pop())
                popped = self.popStack.pop()
                return popped
        
    
    def peek(self) -> int:
        """
        Get the front element.
        """
        s1 = copy.deepcopy(self.pushStack)
        s2 = copy.deepcopy(self.popStack)
        if s2 != []:
            front = s2.pop()
        else:
            while s1 != []:
                s2.append(s1.pop())
            front = s2.pop()
        return front

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.popStack == [] and self.pushStack == []:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
