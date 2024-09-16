class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.in_ = []
        self.out = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.in_.append(x)
        print('In Stack:', self.in_)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        
        if(len(self.out) == 0):
            
            while(self.in_):
                
                self.out.append(self.in_.pop())

            return self.out.pop()
                
        else:
            
            return self.out.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        print('Out Stack:', self.out)
        if(len(self.out)==0):
            
            while(len(self.in_) != 0):
                
                self.out.append(self.in_.pop())

            return self.out[-1]
                    
        return self.out[-1]


    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        
        if(not len(self.in_) and not len(self.out)):
            
            return True
        
        return False
        


#Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
param_3 = obj.peek()
print(param_3)
param_2 = obj.pop()
print(param_2)

param_4 = obj.empty()
print(param_4)