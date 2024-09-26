# -*- coding: utf-8 -*-
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list1 = []
        self.list2 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.list1.append(x)
        #print("push ",x)
        #print(self.list1,self.list2)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.list2:
            self.list2 = self.list1[::-1]
            self.list1 = []
        #print("pop")
        #print(self.list1,self.list2)
        #print("pooped ",self.list2[-1]) 
        return self.list2.pop()
            
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.list2:
          #  print("peek1")
          #  print(self.list1,self.list2,self.list1[0])
            return self.list1[0]
        else:
          #  print("peek2")
         #   print(self.list1,self.list2,self.list2.peek())
            return self.list2[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
       # print(not self.list1 and not self.list2)
        if (not self.list1) and not self.list2:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()