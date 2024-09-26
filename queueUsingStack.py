#Leetcode problem: 232
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.instack=[]     
        self.outstack=[]
        

    def push(self, x): #Time Complexity O(1)
        """
        Push element x to the back of queue.
        """
        #Always push new element in "instack"
        self.instack.append(x)
        
        

    def pop(self): #Time Complexity Amortized O(1)
        """
        Removes the element from in front of queue and returns that element.
        """
        #if outstack is empty then only pop all items from instack and push into outstack one by one and pop from 
        #outstack and then pop from outstack.

        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()
              

    def peek(self): #Time Complexity Amortized O(1)
        """
        Get the front element.
        """
        #similar to pop function but instead of popping just return top of outstack.
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self): #Time Complexity O(1)
        """
        Returns whether the queue is empty.
        """
        return len(self.outstack)==0 and len(self.instack)==0
       
        
#Time Complexity: Amortized O(1) because pop and peek operation can take O(n) once in a while but all the other times
#                 it will be O(1)

#Space complexity: O(n) where n is the number of elements pushed in stack.

#Leetcode Status: All test cases passed.
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()