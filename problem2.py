#Getting time limit exceed in leetcode, not an efficient solution
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.store=[Node(-1)]*10000

    def add(self, key: int) -> None:
        keyMod=key%10000
        newNode=Node(key)
        Node.insert(self.store[keyMod],newNode)

    def remove(self, key: int) -> None:
        keyMod=key%10000
        Node.remove(self.store[keyMod],key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        keyMod=key%10000
        return Node.search(self.store[keyMod],key)
    
class Node:
    def __init__(self,key=0,nextNode=None):
        self.next=nextNode
        self.key=key
    def insert(head,node):
        cur=head
        
        if not Node.search(cur,node.key):
            node.next=head.next
            head.next=node
    def search(head,key):
        cur=head.next
        while(cur!=None):
            if cur.key==key:
                return True
            cur=cur.next
        return False
    def remove(head,key):
        cur=head.next
        prev=head
        while(cur!=None):
            if cur.key==key:
                prev.next=cur.next
                return
            prev=cur
            cur=cur.next
    
        
