"""
Intuition: In this program, 2 stacks are used to implement a queue

First stack is used to push elements.
Second stack is used to pop an element.

#####################################################################
Push Method: Adding an element in the stackOne
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Pop Method: Removing the element
Amortized Time Complexity : O(1)
Worst Case Time Complexity : O(N)
Space Complexity : O(1)
#####################################################################
Peek Method: Accessing the first element entered.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Empty Method: Checking if both the stacks are empty. Accessing the __len__attribute 
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################

"""
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stackOne = []
        self.stackTwo = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stackOne.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #Dumping all elements to stackTwo when stackTwo is empty
        if len(self.stackTwo) == 0:
            while len(self.stackOne):
                self.stackTwo.append(self.stackOne.pop(-1))
        return self.stackTwo.pop(-1)
            
    
    def peek(self) -> int:
        """
        Get the front element.
        """
        #Dumping all elements to stackTwo when stackTwo is empty
        if len(self.stackTwo) == 0:
            while len(self.stackOne):
                self.stackTwo.append(self.stackOne.pop(-1))
        return self.stackTwo[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return True if len(self.stackTwo) == 0 and len(self.stackOne) == 0 else False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()