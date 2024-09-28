# Time Complexity : push : O(1), pop(): Amortized O(1).. Since list in python is implemented as a arraylist.
# O(n) will be there in case of case size is full and reallocation and copying of existing data happens. Else
# O(1) will be for appending and popping last element
# and rest other operation has O(1) time complexity
# Space Complexity: O(n)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.empty():
            return None
        lent = len(self.stack1)
        for i in range(lent -1):
            self.stack2.append(self.stack1.pop())
        item = self.stack1.pop()
       
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())            
        return item
    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack1[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack1) <= 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
