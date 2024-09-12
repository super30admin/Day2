# ----- Please let me know any suggestions or improvements for me to follow.
#Time Complexity : O(1)
#Space Complexity :O(n), due to a list being declared.
# This is implemented and accepted on Leetcode.

class MyQueue:

    def __init__(self):
        self.queue = [] # defining the lists for performing queue operations.

    def push(self, x: int) -> None: 
        self.queue.append(x)# Insert an element in a queue

    def pop(self) -> int:
        if not self.queue: # if the queue is empty
            return None
        return self.queue.pop(0) # remove and return the first element as per the First In First out concept

    def peek(self) -> int:
        if not self.queue: # if the queue is empty
            return None
        return self.queue[0] # returns the first entered element in a queue
        

    def empty(self) -> bool:
        
        if len(self.queue) !=0: # condition to check if the queue is empty or not
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()