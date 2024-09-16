#time complexity - O(1) for push, peek and pop 
#space- O(n) since we used two stacks 
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.st1=[]
        self.st2=[]
             

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.st1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.transfer()
        return self.st2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        self.transfer()
        return self.st2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.st1==[] and self.st2==[]
    def transfer(self)-> None:
        if self.st2==[]:
            while self.st1!=[]:
                self.st2.append(self.st1.pop())
            


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
