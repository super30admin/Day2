class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = []
        
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.q.append(x)
            
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        
        if self.q:
            a = self.q[0]
            self.q = self.q[1:]
            return a

    def peek(self) -> int:
        """
        Get the front element.
        """
        
        if not self.empty():
            return self.q[0]
        
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        
        return len(self.q) == 0
        
queue = MyQueue()
queue.push(1)
queue.push(2)  
print(queue.peek())
print(queue.pop())
print(queue.empty())

'''
Time complexity: O(1);since the list is re-assigned after popping the element;list pointer is 
pointed to the same address after removing the element
'''