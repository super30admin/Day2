'''
# Time Complexity - O(N) for transferring the value from one stack to another
# Space Complexity - O(N) Amortized space complexity for 2nd list

# Algorithm - We are taking 2 stacks. In one as and when we are getting value, we are appending to stack 1
             During pop() and peek() function, if our stack2 is empty, we are popping value from stack1                and append it to stack2. This way the last entered value goes at the bottom and the one                    entered first comes at top of stack2.
             Therefore, while pop and peek, first in will be first out

'''
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list1=[] # Stack 1
        self.list2=[] # Stack 2
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.list1.append(x) # Appending value to stack 1
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        
        if len(self.list2)==0:
            while self.list1:
                self.list2.append(self.list1.pop())
                
        if len(self.list2)==0:
            return -1
                
        return self.list2.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.list2)==0:
            while self.list1:
                self.list2.append(self.list1.pop())
                
        if len(self.list2)==0:
            return -1
                
        return self.list2[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        
        return len(self.list1)==0 and len(self.list2)==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()