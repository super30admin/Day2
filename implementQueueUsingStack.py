
class MyQueue(object):

    def __init__(self):
        self.queueinstack=[]
        self.queueoutstack=[]

        """
        Initialize your data structure here.
        """

    def push(self, x):

        while(self.queueinstack):
            top =self.queueinstack.pop()
            self.queueoutstack.append(top)
        self.queueinstack.append(x)
        while self.queueoutstack:
            top =self.queueoutstack.pop()
            self.queueinstack.append(top)
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """

    def pop(self):
        return self.queueinstack.pop()
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """

    def peek(self):
        self.queueinstack[-1]

        """
        Get the front element.
        :rtype: int
        """

    def empty(self):
       return len(self.queueinstack)>0

if __name__ == '__main__':
    ls=[23,89,90,99]
    stack = MyQueue()
    for element in ls:
        stack.push(element)
    print(stack.pop())





