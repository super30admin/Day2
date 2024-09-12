# Time Complexity: O(n) as we have linkedlist head, so need to traverse it everytime
# Space Complexity: O(1)

class Node():
    def __init__(self, value, next_node=None):
        self.value = value
        self.next_node = next_node

class Bucket():
    
    def __init__(self):
        self.head = Node(float("inf")) # default head pointer
    
    def insert_val(self, value):
        curr_node = self.head
        while curr_node.next_node:
            curr_val = curr_node.value
            if value == curr_val:
                return
            curr_node = curr_node.next_node
            
        if value == curr_node.value:
            return
        else:            
            new_node = Node(value)
            curr_node.next_node = new_node        
        
    def delete_val(self, value):
        curr_node = self.head
        
        while curr_node:
            
            if value == curr_node.value:
                prev.next_node = curr_node.next_node                             
                return
            prev = curr_node
            curr_node = curr_node.next_node
        
    def exists_val(self, value):
        curr_node = self.head
        while curr_node:
            if value == curr_node.value:
                return True 
            curr_node = curr_node.next_node
        
        return False
        
class MyHashSet():
    
    def __init__(self):
        self.base_modulo = 2069
        self.hash_set = [Bucket() for i in range(self.base_modulo)]
        
    def hash_it(self, key):
        hashed = key % self.base_modulo
        return hashed
    
    def add(self, value):
        hashkey = self.hash_it(value)
        self.hash_set[hashkey].insert_val(value)
        
    def remove(self, value):
        hashkey = self.hash_it(value)
        self.hash_set[hashkey].delete_val(value)        
        
    def contains(self, value):
        hashkey = self.hash_it(value)
        return self.hash_set[hashkey].exists_val(value)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)