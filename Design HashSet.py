class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        self.size = 1000
        self.slots = [None] * self.size
        
        
    def add(self, key):
        hashvalue = key % self.size                      
        
        if self.slots[hashvalue] == None:                
            self.slots[hashvalue] = ListNode(key)
               
        else:                                            
            current = self.slots[hashvalue]              
            while True:
                if current.key == key:              
                    return
                if current.next == None:                 
                    break           #break from while loop
                current = current.next                  
                
            current.next = ListNode(key)
        

    def remove(self, key):
        hashvalue = key % self.size
        current = self.slots[hashvalue]
        
        if not current:
            return     
        if current.key == key:         
            self.slots[hashvalue] = current.next    
        while current.next:
            if current.next.key == key:
                current.next = current.next.next 
                return
            else:
                current = current.next
        return
        
        
    def contains(self, key: int) -> bool:
        hashvalue = key % self.size
        current = self.slots[hashvalue]
        while current:
            if current.key == key:
                return True
            current = current.next
        return False
            
            
            
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)