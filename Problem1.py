# Time Complexity :- contains O(1) for push , pop , peek and empty
# Space Complexity : - O(N) where N is the number of elements we want in queue
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.queue = []

    def push(self, x: int) -> None:
        self.queue.append(x)
        print("Push",self.queue)

    def pop(self) -> int:
        poppedElement = self.queue[0]
        del self.queue[0]
        return poppedElement

    def peek(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        if self.queue!=[]:
            return False
        else:
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()s