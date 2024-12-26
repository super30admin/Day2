#Time Complexity:-  
#put(key, value): 𝑂(1) O(1) average, 𝑂(n) worst-case (traversing a linked list)
# get(key):𝑂(1) average, O(n) worst-case
# remove(key): 𝑂(1) average,O(n) worst-case
#Space Complexity :- O(n)

class MyHashMap:
    class Node(object):    
        def __init__(self,key,val):
            self.key = key #key of the node 
            self.val = val # value of the node
            self.next = None # pointer to the next node    
    def __init__(self):
        # Initialize the hash map with a fixed size array of None
        self.Hashlist = [None] * 10000    

    def put(self, key: int, value: int) -> None:
        i = self.hash(key)
        if self.Hashlist[i] is None:
            self.Hashlist[i] = self.Node(-1,-1)
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            prev_node.next = self.Node(key,value)
        else:
            prev_node.next.val = value 
           
    def get(self, key: int) -> int:
        i = self.hash(key)
        if self.Hashlist[i] is None:
            return -1
        prev_node = self.find_node(self.Hashlist[i], key)    
        return -1 if prev_node.next is None else prev_node.next.val

    def remove(self, key: int) -> None:
        i = self.hash(key)
        if self.Hashlist[i] is None:
            return
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            return
        prev_node.next = prev_node.next.next
    #hash function
    def hash(self,key):
        return key % len(self.Hashlist)
    # to find the node 
    def find_node(self,head,key):
        curr = head
        prev = None
        while curr is not None and curr.key!= key:
            prev = curr
            curr = curr.next
        return prev

        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)