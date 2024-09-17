class MyQueue:

    def __init__(self):
        self.stack=[]
    
    def push(self, x: int) -> None:
        self.stack.append(x)
        
    #Removes the element from in front of queue and returns that element.
    def pop(self) -> int:
        return self.stack.pop(0)
        
    #Get the front element
    def peek(self) -> int:
        return self.stack[0]
        
    #Returns whether the queue is empty
    def empty(self) -> bool:
        return not self.stack