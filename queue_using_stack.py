class MyQueue:

    def __init__(self):
        """
        Initialize the data structure.
        One stack to keep track of front of queue and other to keep track of rear stack.
        Takes O(1) time
        """
        self.front_stack = []  # elements are popped from this stack
        self.rear_stack = []  # elements are added to this stack

    def push(self, x: int) -> None:
        """
        :param x: the value to be pushed into the rear stack (end of stack)
        :return: None
        Takes O(1) time
        """
        self.rear_stack.append(x)

    def pop(self) -> int:
        """
        The idea is to check if any element is in the front stack if yes then return the last element.
        If not, then move all the elements of the rear stack to the front stack and return the last element of
        front_stack.
        The elements are moved to front stack only when it is empty.
        :return: the popped value from the rear stack (end of stack)
        Takes O(1) time
        """
        if self.front_stack:
            el = self.front_stack.pop()
            return el
        else:
            while self.rear_stack:
                el = self.rear_stack.pop()
                self.front_stack.append(el)
            el = self.front_stack.pop()
            return el

    def peek(self) -> int:
        """
        :return: the last element of front stack if not empty else return first element of rear stack.
        Takes O(1) time
        """
        if self.front_stack:
            return self.front_stack[-1]
        else:
            return self.rear_stack[0]

    def empty(self) -> bool:
        """
        check if front or rear stacks are empty
        :return: boolean
        Takes O(1) time
        """
        if self.front_stack and self.rear_stack:
            return True
        return False

    def get_rear(self):
        return self.rear_stack

    def get_front(self):
        return self.front_stack
    # Your MyQueue object will be instantiated and called as such:


obj = MyQueue()
obj.push(1)
obj.push(2)
print(obj.get_rear())
param_2 = obj.pop()
print(obj.get_front())
param_3 = obj.peek()
param_4 = obj.empty()
