# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# Queue is an FIFO (First In First Out) data structure
# So instead of appending the element to the last just insert the new element at the start.
# So when we pop we get the fist element out of the list.

class MyQueue:
    def __init__(self):
        self.queue = []
        self.queue1 = []
    # def push(self, x: int) -> None:
    #     self.queue.insert(0, x)
    #
    # def pop(self) -> int:
    #     if self.queue:
    #         return self.queue.pop()
    #
    # def peek(self) -> int:
    #     if self.queue:
    #         return self.queue[-1]
    #
    # def empty(self) -> bool:
    #     return self.queue == []

    def push(self, x):
        self.queue.append(x)

    def pop(self):
        if not self.queue1:
            while self.queue:
                self.queue1.append(self.queue.pop())
        return self.queue1.pop()

    def peek(self):
        if not self.queue1:
            while self.queue:
                self.queue1.append(self.queue.pop())
        return self.queue1[-1]

    def empty(self):
        return self.queue == [] and self.queue1 == []


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print(obj.peek())
print(obj.pop())
print(obj.empty())