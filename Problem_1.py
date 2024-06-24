"""
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
"""


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class MyQueue:

    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, x: int) -> None:
        node = ListNode(x)
        if self.head is None:
            self.head = self.tail = node
            
        else:
            self.tail.next = node
            self.tail = node
        
        

    def pop(self) -> int:
        if self.head:
            value = self.head.val
            temp = self.head.next
            self.head.next = None
            self.head = temp
            return value
        return None
    
    

    def peek(self) -> int:
        if self.head:
            return self.head.val
        
        return None
        

    def empty(self) -> bool:
        if self.head:
            return False
        
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()