"""

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Time Complexity:
- Push: O(1) (appending to a list is O(1))
- Pop: Amortized O(1) (each element moves from inStack to outStack once)
- Peek: Amortized O(1) (same reasoning as pop)
- Empty: O(1) (checking length is O(1))

Space Complexity: O(n), where n is the number of elements stored in the queue.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# used two stacks (inStack and outStack) to implement a queue. 
# The push operation simply appends to inStack, while pop and peek operations transfer elements from inStack to outStack 
# only when outStack is empty, ensuring amortized O(1) time complexity for each operation.

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()


    def peek(self) -> int:
        if not len(self.outStack):
            while len(self.inStack) > 0:
                self.outStack.append(self.inStack.pop())

        return self.outStack[-1]
        

    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

