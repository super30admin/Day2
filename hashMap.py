#Time Complexity :   O (1) 
#Space Complexity :  O(n) 
#Did this code successfully run on Leetcode :    Yes
#Any problem you faced while coding this :       No

class Node:
    def __init__(self, key, val):
        self.key = key
        self.value = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.storage = [None]*self.buckets
        
    def compute_hash(self, key):
        hash_value = key%self.buckets
        return hash_value
        
    def find(self, head, key):
        prev = None
        current = head
        while current is not None and current.key != key:
            prev = current
            current = current.next
        return prev
        
    def put(self, key: int, value: int) -> None:
        #case1: no head node in storage array
        #case 2: update values
        #case 3: find suitable place to add node using find()
        hash_value = self.compute_hash(key)
        if self.storage[hash_value] is None:
            dummy_node = Node(-1, -1)
            self.storage[hash_value] = dummy_node
        
        position_node = self.find(self.storage[hash_value], key)
        if position_node.next is not None:
            position_node.next.value = value
        else:
            position_node.next = Node(key, value)

    def get(self, key: int) -> int:
        #case 1: no node at position in storage array
        #case 2: find and traverse till end of LinkedList
        hash_value = self.compute_hash(key)
        if self.storage[hash_value] is None:
            return -1
        else:
            position_node = self.find(self.storage[hash_value], key)
            if position_node.next is not None:
                return position_node.next.value
            else:
                return -1 

    def remove(self, key: int) -> None:
        #case 1: no node at position in storage array
        #case 2: find and traverse till end of LinkedList
        hash_value = self.compute_hash(key)
        if self.storage[hash_value] is not None:
            position_node = self.find(self.storage[hash_value], key)
            if position_node.next is not None:
                position_node.next = position_node.next.next
            


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)