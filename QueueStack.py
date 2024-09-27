class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        Algorithm:
        1. Maintain 2 stacks: in_stack, out_stack
        2. Push all the elements in the in_stack as an when they come
        3. Pop: Check if out_stack is empty, if out_stack is empty, then add all elements from in_stack to out_stack
            and pop out first element from out_stack
        4. Peek: Check if out_stack is empty, if out_stack is empty, then add all elements from in_stack to out_stack
            and return first element from out_stack
        """
        self.in_stack = []
        self.out_stack = []
        

    def push(self, x: int):
        """
        Push element x to the back of queue.
        """
        self.in_stack.append(x)
        
    def transfer_ele_in_stack_out_stack(self):
        if len(self.out_stack) == 0:
            self.out_stack = self.in_stack[::-1]
            self.in_stack = []
    
    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        """
        popped_element = self.peek()
        
        if popped_element == None:
            return None
        
        self.transfer_ele_in_stack_out_stack()
        self.out_stack.pop()
        return popped_element
    
        

    def peek(self) :
        """
        Get the front element.
        """
        # Check if out_stack is empty or not
        if self.empty():
            return None
        
        self.transfer_ele_in_stack_out_stack()
        return self.out_stack[-1]
    

    def empty(self):
        """
        Returns whether the queue is empty.
        """
        print("self.in_stack :", self.in_stack)
        print("self.out_stack :", self.out_stack)
        
        
        if len(self.in_stack) == 0 and len(self.out_stack) == 0:
            return True
        else:
            return False
        