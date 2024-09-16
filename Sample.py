class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        return self.stack.append(x)
        
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.stack) > 0:
            return self.stack.pop(0)
        else:
            return None

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack) > 0:
            return self.stack[0]
        else:
            return None
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = [[] for _ in range(10000)]

    def add(self, key: int) -> None:
        subkey = key%10000
        if not self.contains(key):
            self.buckets[subkey].append(key)
                       
    def remove(self, key: int) -> None:
        subkey = key%10000
        if self.contains(key):
            self.buckets[subkey].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        subkey = key%10000
        return key in self.buckets[subkey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
