class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Initializing the two stacks 
        self.stack = []
        self.queue = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        #Appending element x to the back of the queue
        self.stack.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #using peek function to get the front element and return it
        self.peek()
        return self.queue.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        #checking if the queue is empty check for the stack
        if self.queue == []:
            #if stack not empty
            while self.stack != []:
                #pop out all the elements from stack to queue
                self.queue.append(self.stack.pop())
        #Return the front value in the queue
        return self.queue[-1]
        
    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        #If stack and queue both are empty return true
        return self.queue == [] and self.stack == []
        
#Using two stack to implement Queue and FIFO,with all the operations the time complexity is O(1).

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()