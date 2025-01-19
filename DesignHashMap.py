class MyHashMap:
    class Node:
        def __init__(self,key=None, value=None, next=None):
            self.key=key
            self.value=value
            self.next=None
    def __init__(self):
        self.arr=[None]*10000
    
    def hash_func(self,key):
        return key%10000
    def find(self,head,key):
        prev=None
        curr=head
        while (curr!=None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx=self.hash_func(key)
        if self.arr[idx]==None:
            self.arr[idx]=self.Node(-1,-1,None)
        prev=self.find(self.arr[idx],key)
        if prev.next==None:
            prev.next=self.Node(key,value,None)
        else:
            prev.next.value=value

    def get(self, key: int) -> int:
        idx=self.hash_func(key)
        if self.arr[idx]==None:
            return -1
        else:
            prev=self.find(self.arr[idx],key)
            if prev.next!=None:
                return prev.next.value
            else:
                return -1

        

    def remove(self, key: int) -> None:
        idx=self.hash_func(key)
        if self.arr[idx]==None:
            return
        prev=self.find(self.arr[idx],key)
        if prev.next==None:
                return 
        else:
            prev.next=prev.next.next

        


