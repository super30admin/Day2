class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None
        


class MyHashMap:

    def __init__(self):
        self.s=[]
        self.buckets = 10001
        self.s = [None] * 10001
           
    def getkey(self,key):
        return key % 10001
    
 
            

    def put(self, key: int, value: int) -> None:
        index = self.getkey(key)
        new_node = Node(key,value)
        
        if(self.s[index] is None):
            
            self.s[index] = new_node
        else:
            prev = None
            cur = self.s[index]
            while(cur != None):
                if(cur.key == key):
                    cur.val = value
                    return
                prev = cur
                cur = cur.next
            prev.next = new_node 
            
        

    def get(self, key: int) -> int:
        index = self.getkey(key)
        cur = self.s[index]
        while(cur is not None):
            if(cur.key == key):
                
                return cur.val
            print(cur.key)
            cur = cur.next      
        return -1
                
        
        
        

    def remove(self, key: int) -> None:
        index = self.getkey(key)
        if(self.s[index] is None):
            return
        else:
            prev = self.s[index]
            cur = self.s[index]
            if(cur.key == key):
                self.s[index] = cur.next
            cur = cur.next
            while(cur != None):
                if(cur.key == key):
                    prev.next = prev.next.next
                prev = cur
                cur = cur.next
                    
            return
        
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)