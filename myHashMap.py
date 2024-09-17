# Time Complexity:
    # put function = O(1)
    # remove function = O(n)
    # get function = O(n)
# Space Complexity = O(n)


class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:
    

    def __init__(self):
        self.buckets = 10000
        self.primaryArr = [Node(None,None)] * self.buckets
        
    
    def getBucket(self, key: int):
        return key % self.buckets
    
        
    
    def find(self, key, head: Node):
        prev = head
        curr = head.next
        # To check if the Node is present or if the key is present
        while(curr != None and curr.key!=key):
            prev = curr
            curr = curr.next
        # Returns previous node in case there is a 'find'
        return prev
    

    def put(self, key: int, val: int) -> None:
        index = self.getBucket(key)
        # To check if the LL is initialised or not. If not, add a dummy head
        if self.primaryArr[index] is None:
            self.head = Node(-1, -1)
        # Calling find() to check the presence
        prev = self.find(key, self.primaryArr[index])
        # It means node or key,val pair is not present
        if prev.next is None:
            prev.next = Node(key, val)
        # It means the same key exists, so update teh val
        else:
            prev.next.val = val
            
    

    def get(self, key: int) -> int:
        index = self.getBucket(key)
        if self.primaryArr[index] is None:
            return -1
        prev = self.find(key, self.primaryArr[index])
        if prev.next is None:
            return -1
        return prev.next.val
        
        
        

    def remove(self, key: int) -> None:
        index = self.getBucket(key)
        if self.primaryArr[index] == None:                 
            return
        prev = self.find(key, self.primaryArr[index])
        if prev.next == None:                           
            return
        prev.next = prev.next.next 
        
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
