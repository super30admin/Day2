#Time Complexity : O(N/K) where K = 1000
#Did this code successfully run on Leetcode : Yes, 228 ms
#Any problem you faced while coding this : No
class Node: 
    def __init__(self,data,nextN = None):
        self.data = data
        self.next = nextN
        
class StoreArr:
    def __init__(self):
        self.head = Node(-1)
        
    def existsInStore(self,data):
        temp = self.head.next
        while temp is not None:
            if temp.data == data:
                #print('Contains',data)
                return True
            temp = temp.next
        return False
    
    def insert(self,data):
        newNode = Node(data)
        temp = self.head
        if not self.existsInStore(data):
            while temp.next != None:
                temp = temp.next
            temp.next = newNode

    def delete(self,data):
        prev = self.head
        nextNode = self.head.next
        while nextNode is not None:
            if nextNode.data == data:
                prev.next = nextNode.next
                nextNode = None
                #print('Removed',data)
                return 
            prev = nextNode
            nextNode = nextNode.next
    
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arrSize = 1000
        self.arr = [StoreArr() for i in range(0,1000)]
      
    def _hash(self,key):
        return key%self.arrSize

    def add(self, key: int) -> None:
        index = self._hash(key)
        self.arr[index].insert(key)
        #print('Inserted',key)

    def remove(self, key: int) -> None:
        index = self._hash(key)
        self.arr[index].delete(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = self._hash(key)
        return self.arr[index].existsInStore(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
