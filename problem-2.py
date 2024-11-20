# Time and space complexity is O(n)
# was able to run on leetcode

#Creating the linkedlist
class ListNode:
    def __init__(self,key,val):
        self.key = key
        self.val=val
        self.next = None

class MyHashSet:
# Initializing the hashset
    def __init__(self):
        self.size=1000
        self.hashset=[None]*self.size


    def add(self, key: int) -> None:
#Finding the index
        index = key % self.size
#Checking to see if there is already something stored at that index otherwise inserting at the end of linkedlist
        cur_node = self.hashset[index] 
        if cur_node is None:
            self.hashset[index] = ListNode(key,True)
        else: 
            while cur_node:
                if cur_node.key == key:
                    cur_node.val=True
                if cur_node.next is None:break
                cur_node= cur_node.next
            cur_node.next = ListNode(key,True)

    def remove(self, key: int) -> None:
#Finding the index
        index = key%self.size
        cur_node = self.hashset[index]
        
# Checking to see if there if value at the specified index, if its present removing it otherwise traversing to find and remove the value
        if cur_node is None:
            return
        else:
            while cur_node:
                if cur_node.key == key:
                    cur_node.val=False
                cur_node = cur_node.next
        
    def contains(self, key: int) -> bool:
#Finding the index
        index = key % self.size
        cur_node = self.hashset[index]
#Checking to see if the value is present at index if its present return true otherwise return false
        if cur_node is None:
            return False
        else:
            while cur_node:
                if cur_node.key == key:
                    if cur_node.val==True:
                        return True
                    else:
                        return False
                cur_node =cur_node.next
        return False
