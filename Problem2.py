# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Node:
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSet = [None]*10000
    
    def hashVal(self,key: int) -> int:
        return hash(key) % 10000
    
    def find(self,head: Node,key: int):
        temp = head
        prev = None
        while temp != None and temp.key != key:
            prev=  temp
            temp = temp.next
        return prev

    def add(self, key: int) -> None:
        a = self.hashVal(key)
        if self.hashSet[a] == None:
            self.hashSet[a] = Node(key)
        else:
            node = self.find(self.hashSet[a],key)
            if node != None and node.next == None:
                node.next = Node(key)



    def remove(self, key: int) -> None:
        a = self.hashVal(key)
        if self.hashSet[a] != None:
            node = self.find(self.hashSet[a],key)
            if node != None:
                if node.next == None:
                    node = None
                else: node.next = node.next.next


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        a = self.hashVal(key)
        if self.hashSet[a] == None:
            return False
        node = self.find(self.hashSet[a],key)
        if node == None:
            return True
        elif node.next == None:
            return False
        else: return True
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)