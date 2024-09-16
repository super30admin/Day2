# Time Complexity - O(N)
#Space Complexity - O(N)

# Similar to HashMap implementation
# ListNode to store key and value
class ListNode:
    def __init__(self,key):
        self.key = key
        self.next = None
        
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.nodes = [None]*self.size
        
    # Hashing funtion
    def getHash(self,key):
        return key%self.size
    
    def findElement(self,key,head):
        prev=None
        cur = head
        
        while(cur != None and cur.key!=key):
            prev=cur
            cur=cur.next
            
        return prev
        

    def add(self, key: int) -> None:
        
        hash_value = self.getHash(key)
        if self.nodes[hash_value]==None:
            self.nodes[hash_value]=ListNode(-1) # Creating a dummy node at the beginning
        prev = self.findElement(key,self.nodes[hash_value])
        
        # If key does not exist, then create a new ListNode with given key and value as next of prev node
        if prev.next==None:
            prev.next = ListNode(key)
        

    def remove(self, key: int) -> None:
        
        hash_value = self.getHash(key)
        if self.nodes[hash_value] == None:
            return
        prev = self.findElement(key,self.nodes[hash_value])
        
        if prev.next==None:
            return
        
        prev.next=prev.next.next
        
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_value = self.getHash(key)
        
        # base case 
        if self.nodes[hash_value] == None:
            return False
        prev = self.findElement(key,self.nodes[hash_value])
        
        if prev.next == None:
            return False
        
        return True
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)