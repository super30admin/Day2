# In this problem I use list as a stack to implement queue from the stack.
# Time Complexity - push - O(1), pop,peek - O(n), isEmpty - O(1)
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue = list()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.queue.append(x)
        print("Inserting into the list")

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        stack = list()
        if (len(self.queue)!=0):
            for i in range((len(self.queue)-1),-1,-1):
                stack.append(self.queue[i])
            elem = stack[-1]
            self.queue.remove(elem)
            return elem
        else:
            return -1

    def peek(self) -> int:
        """
        Get the front element.
        """
        stack = list()
        if (len(self.queue)!=0):
            for i in range((len(self.queue)-1),-1,-1):
                stack.append(self.queue[i])
            return stack[-1]
        else:
            return -1

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (len(self.queue)==0):
            return True
        else:
            return False
        
# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(2)
obj.push(3)
obj.push(1)
obj.push(4)
param_2 = obj.pop()
print("Element popped: ",param_2)
param_3 = obj.peek()
print("Peeking: ",param_3)
param_4 = obj.empty()
print("Is stack eempty: ",param_4)
