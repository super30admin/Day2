#Time complexity: O(1)
#Space complexity:0(n)
class MyQueue:

    def __init__(self):
        self.lst1 = []
        self.lst2 = []

    #Time complexity: O(1)
    #Space complexity:O(1)
    def push(self, x: int) -> None:
        self.lst1.append(x)

    # Worstcase Time complexity: O(n))
    #Space complexity:O(n)
    def pop(self) -> int:
        self.peek()
        return self.lst2.pop()

    # Worstcase Time complexity: O(n))
    #Space complexity:O(n)
    def peek(self) -> int:
        if self.lst2 == []:
            while self.lst1:
                self.lst2.append(self.lst1.pop())
        return self.lst2[-1]
    #Time complexity: O(1))
    #Space complexity:O(1)
    def empty(self) -> bool:
        return not self.lst1 and not self.lst2
