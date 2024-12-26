class ListNode:
    def __init__(self,key,val,next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        # initialise the bucket storage
        self.buckets = 1000
        self.storage = [None]*(self.buckets)

    def getBucket(self,key) -> int:
        # hash function to fetch key
        return int(key) % 1000
    
    def find(self,dummy,key) -> ListNode:
        # Checks if given key is present in the list and provides prev node value
        prev,cur = None,dummy
        while cur != None and cur.key != key:
            prev = cur
            cur = cur.next
        return prev

    def put(self, key: int, value: int) -> None:
        # Checks if key is present in the list and updates the value if key is present or creates new node at end of list
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = ListNode(-1,-1)
        
        prev = self.find(self.storage[bucket],key)
        if prev.next != None:
            prev.next.val = value
        else:
            prev.next = ListNode(key,value)
        

    def get(self, key: int) -> int:
        # checks if key is present in the list and returns value if key is present, else returns -1
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(self.storage[bucket],key)
        if prev.next == None:
            return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        # checks if key is present and removes the node in accordingly.
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return 
        prev = self.find(self.storage[bucket],key)
        if prev.next != None:
            prev.next = prev.next.next
# avg TC: O(n)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)git 