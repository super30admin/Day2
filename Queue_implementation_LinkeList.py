// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Solved Using Linekd List and please correct me if my time and space complexities are wrong.

class Node:
      def __init__(self,val):
        self.val = val
        self.next = None


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.tail = None
        self.length = 0

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        new_node = Node(x)
        if self.head == None:
            self.head = new_node
            self.tail = self.head
            self.length += 1
        else:
            self.tail.next = new_node
            self.tail = new_node
            self.length += 1

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        temp = self.head.next
        popped = self.head.val
        if self.head.next == None:
            self.head = None
            self.length -= 1
        else:
            self.head.next = None
            self.head = temp
            self.length -= 1
        return popped    

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.head.val

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.length == 0:
            return 1


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
