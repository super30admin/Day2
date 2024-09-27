class LinkedList:
    def __init__(self,value):
        self.data = value
        self.next=None

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m=100
        self.h = [None]*100
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_key = key % self.m
        if self.h[hash_key]==None:
            self.h[hash_key] = LinkedList(key)
            return
        else:
            cur = self.h[hash_key]
            while(cur!=None):
                if cur.data==key:
                    return
                if cur.next==None:
                    break
                cur=cur.next
            cur.next = LinkedList(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_key = key%self.m
        if self.h[hash_key]==None:
            return
        else:
            cur = self.h[hash_key]
            print(cur.data)
            prev = self.h[hash_key]
            if cur.data==key:
                self.h[hash_key] = cur.next
            cur=cur.next
            while(cur!=None):
                if cur.data==key:
                    prev.next =cur.next
                cur=cur.next
                prev=prev.next
                    
        
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        hash_key = key%self.m
        if self.h[hash_key]==None:
            return False
        else:
            cur = self.h[hash_key]
            while(cur!=None):
                if cur.data == key:
                    return True
                cur=cur.next
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)