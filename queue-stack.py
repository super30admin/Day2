# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

# // Your code here along with comments explaining your approach


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
        self.inst=[]
        self.outst=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inst.append(x)
        print(self.inst)
        print(self.outst)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if (len(self.outst)==0):
            while(len(self.inst)!=0):
                a=self.inst.pop()
                self.outst.append(a)
        return self.outst.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (len(self.outst)==0):
             while(len(self.inst)!=0):
                a=self.inst.pop()
                self.outst.append(a)
        return self.outst[-1]
        
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        print(self.inst)
        print(self.outst)
        if len(self.inst)!=0 or len(self.outst)!=0:
            return False
        else:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()