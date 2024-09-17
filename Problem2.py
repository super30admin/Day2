class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input_stack=[]
        self.output_stack=[]
        

    def push(self, x) :
        """
        Push element x to the back of queue.
        """
        #In this case we simply need to push element 
        #No other step is required
        self.input_stack.append(x)
        print("Element pushed...Current queue:")
        print(self.input_stack)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.output_stack.pop()
        

    def peek(self):
        """
        Get the front element.
        """
   
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())
        if self.output_stack:
            return self.output_stack[-1]
        
        

    def empty(self) :
        """
        Returns whether the queue is empty.
        """
        return not self.input_stack and not self.output_stack


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(3)
obj.push(1)
obj.push(-1)
param_2 = obj.pop()
print("Element popped from queue ")
print(param_2)
param_3 = obj.peek()
print("Current top element of queue: ")
print(param_3)
param_4 = obj.empty()
print("Is queue empty??")
print(param_4)
#Time Complexity: O(1)

#Space Complexity:O(n)