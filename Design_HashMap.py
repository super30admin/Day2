class Node:
    def __init__(self,key=None,value=None,nxt=None):
        self.key=key
        self.val=value
        self.nxt=nxt

class MyHashMap:

    def __init__(self):
        self.i=int(math.pow(10,4))
        self.l=[None for _ in range(self.i)]
        
    def convert(self,key):
        return key % self.i
        

    def put(self, key: int, value: int) -> None:
        p=self.convert(key)
        
        if self.l[p]==None:
            self.l[p]=Node(-1,-1)
            
        prev=self.find(self.l[p],key)
        
        if prev.nxt is None:
            prev.nxt=Node(key,value)
        else:
            prev.nxt.val=value
            
            
    def find(self,head,key):
        
        prev=head
        curr=head.nxt
        
        while curr is not None and curr.key!=key:
            prev=curr
            curr=curr.nxt
            
        return prev

    def get(self, key: int) -> int:
        p=self.convert(key)
        
        if self.l[p]==None:
            return -1
        
        prev=self.find(self.l[p],key)
            
        if prev.nxt is None:
            return -1
            
        return prev.nxt.val
        

    def remove(self, key: int) -> None:
        p=self.convert(key)
        
        if self.l[p]==None:
            return
        
        prev=self.find(self.l[p],key)
            
        if prev.nxt is None:
            return
        
        else:
            prev.nxt=prev.nxt.nxt
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)-