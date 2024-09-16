// Time Complexity : push, peek, empty - O(1), pop - O(n), 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Questions - As we are using 2 stack, would space complexity be O(2n)? For pop, can we call
time complexity as amortized O(1)?


// Your code here along with comments explaining your approach - 
1. For push, we simply append the value to stack 1.
2. Initially, for pop and peek operation, we utilized a secondary stack s2 (nicknamed the "queue" stack as it resembles queue) to empty the 
elements of the initial stack and reverse the order during the process. Therefore, the first element in initial stack, which turns out 
to be the last element in the secondary stack, is removed and fetched using pop function. 
3. Thereafter, I tried using a variable to store the peek value and reduce it's time complexity from O(n) in worst case to O(1).
4. For empty operation, we used 'not' operator to check if both the stacks are empty.
	
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []
        self.first = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if not self.s1:
            self.first = x
        self.s1.append(x)
            

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        """
        if self.s2:
            return self.s2[-1]   #If this isn't allowed, we can pop and assign to a variable and subsequently append it to s2. Return variable.
        return self.first


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.s1 and not self.s2
