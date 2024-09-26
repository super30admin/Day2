class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = []
        pass
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.list.append(x)
        pass
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        pop_value = self.list[0]
        self.list = self.list[1:]
        return pop_value
        pass

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.list[0]
        pass

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.list:
            return True
        else:
            return False
        pass
