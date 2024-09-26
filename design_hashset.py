class MyHashSet:
    def __init__(self):
        self.hashset = [LinkedList() for i in range(769)]
    def add(self, key: int) -> None:
        normalized_key = key % 769
        self.hashset[normalized_key].insert(key)
    def remove(self, key: int) -> None:
        normalized_key = key % 769
        self.hashset[normalized_key].remove(key)
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
        temp = self.head  
  
        # If head node itself holds the key to be deleted  
        if (temp is not None):  
            if (temp.value == value):  
                self.head = temp.next
                temp = None
                return
  
        # Search for the value to be deleted, keep track of the  
        # previous node as we need to change 'prev.next'  
        while(temp is not None):  
            if temp.value == value:  
                break
            prev = temp  
            temp = temp.next
  
        # if key was not present in linked list  
        if(temp == None):  
            return
  
        # Unlink the node from linked list  
        prev.next = temp.next
  
        temp = None


