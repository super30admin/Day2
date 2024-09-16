class MyHashMap:
    class Node:
        def __init__(self,key=None,value=None):
            self.key=key
            self.value=value
            self.next=None

    def __init__(self):
        self.map=[None]*10001

    def put(self, key: int, value: int) -> None:#time O(n) sapce O(1)
        idx=self.findIdx(key)
        if self.map[idx]==None:
            self.map[idx]=self.Node(-1,-1)
        prev_node=self.find_node(self.map[idx],key)
        if prev_node.next==None:
            prev_node.next=self.Node(key,value)
        else:
            prev_node.next.value=value

    def get(self, key: int) -> int:#time O(n) sapce O(1)
        idx=self.findIdx(key)
        if self.map[idx]==None:return -1
        prev_node=self.find_node(self.map[idx],key)
        if prev_node.next==None:return -1
        else:
            return prev_node.next.value


    def remove(self, key: int) -> None:#time O(n) sapce O(1)
        idx=self.findIdx(key)
        if self.map[idx]==None:return
        prev_node=self.find_node(self.map[idx],key)
        if prev_node.next==None:return
        prev_node.next=prev_node.next.next

    def findIdx(self,key):
        return hash(key)%len(self.map)

    def find_node(self,head,key):
        cur=head
        prev=None
        while cur!=None and cur.key!=key:
            prev=cur
            cur=cur.next
        return prev




# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
