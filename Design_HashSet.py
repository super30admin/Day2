# overall space is O(K + U) where K == 769 AND U is no.of values inserted
class MyHashSet:
    def __init__(self):
        self.hashset = [LinkedList() for i in range(769)]
    # add method takes O(1) time
    def add(self, key: int) -> None:
        normalized_key = key % 769
        self.hashset[normalized_key].insert(key)
    # remove takes O(n) time
    def remove(self, key: int) -> None:
        normalized_key = key % 769
        self.hashset[normalized_key].remove(key)
    # contains takes O(n) time
    def contains(self, key: int) -> bool:
        normalized_key = key % 769
        return self.hashset[normalized_key].exists(key)

class Node:
    def __init__(self,value = None):
        self.value = value
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def exists(self,value):
        current = self.head
        while current is not None:
            if current.value == value:
                return True
            current = current.next
        return False
    
    def insert(self,value):
        if self.exists(value):
            return
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            return
        new_node.next = self.head.next
        self.head.next = new_node
    
    def remove(self,value):
        current = self.head  
        if (current is not None):  
            if (current.value == value):  
                self.head = current.next
                current = None
                return  
        while(current is not None):  
            if current.value == value:  
                break
            prev = current  
            current = current.next
        if(current == None):  
            return
        prev.next = current.next
        current = None
