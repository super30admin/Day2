# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Not sure whether correct


class Node:
    def __init__(self,key,data):
        self.key=key
        self.data=data
        self.next=None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
        self.hashs=[[]]*1000
    def find(self,head,key):
        prev=head
        current=head.next
        while(current!= None and current.key!=key):
            prev=current
            current=current.next
        return prev
        
        
        
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index=hash(key)%1000
        if self.hashs[index] == []:
            self.hashs[index]=Node(-1,-1)
        prev=self.find(self.hashs[index],key)
        if prev.next == None :
            prev.next=Node(key,value)
        else:
            prev.next.data=value
        print(prev.next.data)
            
        
        
            
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index=hash(key)%1000
        if self.hashs[index]==[]:
            return -1
        prev=self.find(self.hashs[index],key)
        if prev.next==None:
            return -1
        else:
            return prev.next.data
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index=hash(key)%1000
        if self.hashs[index]==[]:
            return 
        prev=self.find(self.hashs[index],key)
        if prev.next==None:
            return 
        else:
            prev.next=prev.next.next
            


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
