class Node:
    def __init__(self,key):
        self.val = key
        self.next = None

class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.arr = [None] * self.size
        
    def add(self, key: int) -> None:
        index = key % self.size
        if not self.arr[index]:
            self.arr[index] = Node(key)
        else:
            head = self.arr[index]
            while head.val != key and head.next:
                head = head.next
            if head.val != key:
                head.next = Node(key)

    def remove(self, key: int) -> None:
        if not self.contains(key):
            return
        index = key % self.size
        if self.arr[index].val == key:
            self.arr[index] = self.arr[index].next
            return
        head = self.arr[index]
        while head.next.val != key:
            head = head.next
        head.next = head.next.next

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key % self.size
        if not self.arr[index]:
            return
        head = self.arr[index]
        while head:
            if head.val == key:
                return True
            head = head.next
        return False

hashSet = MyHashSet()
hashSet.add(1)       
hashSet.add(2)      
print(hashSet.contains(1))
print(hashSet.contains(3))
hashSet.add(2)        
print(hashSet.contains(2))
hashSet.remove(2)         
print(hashSet.contains(2))  

'''
Time complexity :O(1) ; since the linked lists are used instead of linear search in a list
'''