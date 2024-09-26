class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []
        self.popstack = []
        self.front = 0

    def push(self, x) :
        """
        Push element x to the back of queue.
        """
        if len(self.stack) == 0:
            self.front = x
        self.stack.append(x)

    def pop(self) :
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.popstack) == 0:
            while len(self.stack) != 0:
                self.popstack.append(self.stack.pop())
        self.popstack.pop()

    def peek(self):
        """
        Get the front element.
        """
        if len(self.popstack) != 0:
            print self.popstack.peek()
        print self.front

    def empty(self) :
        """
        Returns whether the queue is empty.
        """
        if len(self.stack) == 0 and len(self.popstack) == 0:
            print ("stack is empty")
        else :
            print("stack is not empty")

# Your MyQueue object will be instantiated and called as such:
obj=MyQueue()
obj.push(10)
obj.push(20)
obj.pop()
obj.push(30)
obj.push(40)
obj.peek()
obj.empty()