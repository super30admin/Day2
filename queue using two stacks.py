#queue using two stacks
#All operations are amortised O(1)
#Method
#initialize two stacks
#when adding append elements to the main stack only
#when peeking - check if second stack is empty, if it is empty then pop all elements from main stack and append them to second stack,if second stack is not empty then just return last element from the second stack.
#While popping do the same thing, first peek and then pop last element from second stack.

class MyQueue:

    def __init__(self):
        #initialize two stakcs(primary storage arrays)
        self.first_stack=[]
        self.second_stack=[]
        
        

    def push(self, x: int) -> None:
        '''O(1) Time complexity
           O(1) Space complexity'''
        self.first_stack.append(x)
        

    def pop(self) -> int:
        '''O(1) Time complexity - avg case 
            O(1) Space complexity'''
        #first run peek function
        self.peek()
        return self.second_stack.pop()
        
        

    def peek(self) -> int:
            #'''O(1) Time complexity- average case
            #    O(1) Space complexity'''
        #if second stack is empty
        if len(self.second_stack)==0:
            #pop all elements from first stack and append them to second stack
            while len(self.first_stack)!=0:
                self.second_stack.append(self.first_stack.pop())
        #return last element of second stack
        return self.second_stack[len(self.second_stack)-1]
        

    def empty(self) -> bool:
         #'''O(1) Time complexity
         #   O(1) Space complexity'''
        #the stack is empty only if both the stacks are empty.
        return  len(self.first_stack)==0 and len(self.second_stack)==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()