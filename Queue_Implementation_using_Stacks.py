class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # self.stack = []
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)
#         while len(self.stack1)!=0:
#             self.stack2.append(self.stack1.pop())
#         self.stack1.append(x)
#         while len(self.stack2)!=0:
#             self.stack1.append(self.stack2.pop())
#         print(self.stack1)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack1) <= 0  and len(self.stack2) <= 0:
            print("Queue is Empty")
            return
        elif len(self.stack1) > 0 and len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()
        else:
            return self.stack2.pop()
                    
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack1) <= 0  and len(self.stack2) <= 0:
            print("Queue is Empty")
            return
        elif len(self.stack1) > 0 and len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[len(self.stack2)-1]
        else:
            return self.stack2[len(self.stack2)-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack1) <=0 and len(self.stack2) == 0:
            return True
        else:
            return False
        
        

# This implementation is done using two stacks
# This takes O(1) complexity for the push, pop (amortized complexity) , empty and peek operations

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()