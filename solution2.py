class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

class bucket:
    def __init__(self):
        self.head = ListNode(-1)

    def find(self, x):
        head = self.head.next
        while head:        
            if head.val == x:
                return True
            head = head.next
        return False
    
    def delete(self,x):
        head = self.head
        while head.next:
            if head.next.val == x:
                head.next = head.next.next
                break
            head = head.next
    
    def add(self, x):
        head = self.head
        while head.next:
            if head.next.val == x:
                break
            head = head.next
        head.next = ListNode(x)

class HashSet:
    def __init__(self):
        self.N = 2003
        self.array = self.N*[bucket()]
    
    def _hash(self, value):
        return value%self.N

    def add(self, value):
        index = self._hash(value)
        curr = self.array[index]
        curr.add(value)
    
    def contains(self, value):
        index = self._hash(value)
        curr = self.array[index]
        return curr.find(value)

    def remove(self, value):
        index = self._hash(value)
        curr = self.array[index]
        curr.delete(value)


new = HashSet()

new.add(1)
new.add(2)
print(new.contains(1))
print(new.contains(3))
print(new.contains(2))
new.remove(2)
print(new.contains(2))