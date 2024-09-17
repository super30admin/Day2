# problem 1 : Implement Queue using Stacks : https://leetcode.com/problems/implement-queue-using-stacks/
# Time Complexity : Push is O(1) and pop is O(1) in amortized complexity
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
### Using the two stack approach. Here first stack is used as a stack for push operation as the push operation only happens on this stack while second stack is used as pop stack as it is used for pop and peek operation.
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.push_stack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.pop_stack) == 0:
            while len(self.push_stack) != 0:
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.pop_stack) == 0:
            while len(self.push_stack) != 0:
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack[-1]        
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.pop_stack and not self.push_stack:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()



# problem 2 : Design HashSet : https://leetcode.com/problems/design-hashset/
# Time Complexity : Add and remove both are O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
### Using the approach of hashing two times so as to get the exact location of number.
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.data = [False] * self.modulo
        

    def add(self, key: int) -> None:
        data_ind = self.hash(key)
        if not self.data[data_ind]:
            self.data[data_ind] = [False] * self.modulo
            ind = self.hash(key // self.modulo)
            self.data[data_ind][ind] = True
        else:
            ind = self.hash(key // self.modulo)
            self.data[data_ind][ind] = True
            

    def remove(self, key: int) -> None:
        data_ind = self.hash(key)
        if self.data[data_ind]:
            ind = self.hash(key // self.modulo)
            if self.data[data_ind][ind]:
                self.data[data_ind][ind] = False
            

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        data_ind = self.hash(key)
        if self.data[data_ind]:
            ind = self.hash(key // self.modulo)
            return self.data[data_ind][ind]            
        return False
    
    def hash(self, key:int) -> int:
        return key % self.modulo


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)