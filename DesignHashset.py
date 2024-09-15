class Node():
    def __init__(self, key, val,nextp=None):
        self.key = key
        self.val = val
        self.next = nextp
class MyHashMap:

    def __init__(self):
        self.arr=[None]*10001

    def find_pos(self,key):
        traverse = self.arr[key//100]
        while traverse.next!=None and traverse.next.key != key:
            traverse = traverse.next
        return traverse


    def put(self, key: int, val) -> None:
        temp = None
        if not self.arr[key//100]:
            self.arr[key//100]=Node(-1,-1)
            temp = self.arr[key//100]
        else:
            temp = self.find_pos(key)
        if temp.next == None:
            temp.next = Node(key,val)
        else:
            temp.next.val = val
        
    def get(self, key: int) -> None:
        temp = None
        if not self.arr[key//100]:
            return -1
        else:
            temp = self.find_pos(key)
        if temp.next:
            return temp.next.val
        return -1

        

    def contains(self, key: int) -> bool:
        temp = None
        if not self.arr[key//100]:
            return -1
        else:
            temp = self.find_pos(key)
        if temp:
            return temp.next.val
        return -1
    
    def remove(self, key: int) -> None:
        temp = None
        if not self.arr[key//100]:
            return
        else:
            temp = self.find_pos(key)
        if temp.next:
            temp.next = temp.next.next