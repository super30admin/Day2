# Time complexity: O(1) best/average case, O(n) worst case
# Space complexity: O(n)
# Did this code run on leetcode: yes
# Any problem you faced while coding this : Had little trouble while implementing peek method.

'''
Implementation idea is to use two stacks to make it function as a queue.
When push operation is called: we insert the element into the first stack
When pop operation is called: because we need to pop from the front of the queue -> we shift all elements from stack1 to stack2 => this helps us get access to the front element of the queue
When peek operation is called: here we need to take extra care as contnuous pops might have emptied the stacks. If that's not the case, then we can simply return the top element of stack2 ifstack2 is not empty else we perform same shifting operation as in pop and then return that element
Empty operation: we only need to check if both our stacks are empty or not and return the result
'''


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack2) != 0:
            return self.stack2.pop()
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack2) != 0:
            return self.stack2[-1]
        elif len(self.stack2) == 0 and len(self.stack1) != 0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]
        else:
            return -1

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
