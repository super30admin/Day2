class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr=[]


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.arr.append(x)


    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.arr)>0:
            x=self.arr[0]
            self.arr.remove(self.arr[0])
            return x



    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.arr)>0:
            return self.arr[0]



    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.arr)>0:
            return False
        return True



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
