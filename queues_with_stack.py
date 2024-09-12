 # Time Complexity : O(1) for push, Amortised O(1) for pop.
 # Worst Case for pop is O(n) when stack2 is empty and all elements from stack1 is transferred to stack2
 # Space Complexity : O(n)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : None

class MyQueue:
    # initialising empty two stacks
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    # Function to push the element to the stack
    def push(self,value):
        self.stack1.append(value)

    # Function to remove the top most element
    def pop(self):
        self.peek()
        return self.stack2[-1]

    # Function returns the top element in stack 2
    def peek(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    # Function to check if the stack is Empty
    def isEmpty(self):
        return not self.stack1 and not self.stack2

    def print_queue(self):
        return print(self.stack1)
        return print(self.stack2)

my_queue = MyQueue()
while True:
    #Give input as string if getting an EOF error. Give input like "push 10" or "pop"
    print('push <value>')
    print('pop')
    print('peek')
    print('isEmpty')
    print('print')
    print('quit')
    do = input('What would you like to do? ').split()
    #Give input as string if getting an EOF error. Give input like "push 10" or "pop"
    operation = do[0].strip().lower()
    if operation == 'push':
        my_queue.push(int(do[1]))
    elif operation == 'pop':
        popped = my_queue.pop()
        if popped is None:
            print('Queue  is empty.')
        else:
            print('Popped value: ', int(popped))
    elif operation == 'peek':
        print(f"The top element is: {my_queue.peek()}")
    elif operation == 'isEmpty':
        print(f"Queue is Empty if True and Queue is not Empty if False: {my_queue.isEmpty()}")
    elif operation == 'print':
        my_queue.print_queue()
    elif operation == 'quit':
        break
