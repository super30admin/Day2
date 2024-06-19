# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

#Time Complexity: put(),get(),remove() : O(1)
#Space Complexity:O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#deque is chosen because it provides efficient append and pop operations from both ends.
# Approach : Utilizes two deques (stack1 and stack2)- stack1 is used to add elements.stack2 is used for dequeue and peek operations by transferring elements from stack_in when necessary.

from collections import deque
class MyQueue:
    def __init__(self):
        self.stack_in = deque()   
        self.stack_out = deque()

    def push(self, x):
        """Push element x to the back of the queue."""
        self.stack_in.append(x)
        return "null"

    def pop(self):
        """
        Removes the element from in front of the queue and returns that element.
        If stack_out is empty, reverse stack_in into stack_out.
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out.pop()

    def peek(self):
        """
        Get the front element without removing it.
        If stack_out is empty, reverse stack_in into stack_out.
        """
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out[-1]

    def empty(self):
        """Returns whether the queue is empty."""
        return not self.stack_in and not self.stack_out

myQueue = MyQueue()
print(myQueue.push(10))
print(myQueue.push(60))
print(myQueue.push(45))
print(myQueue.pop())
print(myQueue.peek())    
print(myQueue.empty())

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

#Time Complexity: put(),get(),remove() : O(1)
#Space Complexity:O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach : Uses an array of lists (buckets) to store key-value pairs.Each inner list(slots) handles collisions using a list to store multiple key-value pairs. Chosen Lists according to time and space complexity.

class MyHashMap(object):

    def __init__(self):
      self.size = 1000
      self.inner_lists = [[] for i in range(self.size)]

    def _hash(self,key):
        return key % self.size 

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
         # Insert or update a key-value pair in the hash map
        inner_lists_idx = self._hash(key)
        inner_list = self.inner_lists[inner_lists_idx]
        for idx,(existing_key,_) in enumerate(inner_list):
            if existing_key == key:
                inner_list[idx] = [key, value]
                return
    
        inner_list.append([key, value])
        return "null"
        
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        inner_lists_idx = self._hash(key)
        inner_list = self.inner_lists[inner_lists_idx]
        for existing_key, existing_value in inner_list:
            if existing_key == key:
                return existing_value
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        inner_lists_idx = self._hash(key)
        inner_list = self.inner_lists[inner_lists_idx]
        for idx, (existing_key,_) in enumerate(inner_list):
            if existing_key == key:
                del inner_list[idx]
                return "null"


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
print(obj.put(5,12))
print(obj.put(4,16))
print(obj.put(5,60))
print(obj.get(5))
print(obj.get(8))
print(obj.remove(5))



