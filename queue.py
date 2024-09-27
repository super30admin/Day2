# Use two stacks
# On push, keep a pointer to store the first value in stack 1 and push the value in s1.
# On pop, if s2 is empty, pop values from s1 and push them in s2 and then pop values from s2
# On peek, if s2 is not empty, return top value of s2 else return front
# On empty, check whether both the stacks are empty or not

# Time Complexity: push: O(1), pop: O(n), peek: O(1), empty: O(1)
# Space Complexity: push: O(n), pop: O(n), peek: O(1), empty: O(1)

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.front = None
        self.s1 = []
        self.s2 = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        if not self.s1:
            self.front = x
        self.s1.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.s2:
            return self.s2[-1]
        return self.front
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if not self.s1 and not self.s2:
            return True
        return False
        


queue = MyQueue()

queue.push(1)
queue.push(2)  
print(queue.peek())
#  // returns 1
print(queue.pop())
#  // returns 1
print(queue.empty())
#  // returns false