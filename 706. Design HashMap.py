#put, get and remove all are O(n) due to find function
class MyHashMap:
    #Node class needed for Linked list separate chaining
    class Node:
        def __init__(self, key: int, value: int):
            self.key = key 
            self.value = value 
            self.next = None
        
    def find(self, node: Node, key: int) -> Node:
        prev = node
        curr = node.next 
        while curr != None and curr.key != key:
            prev = curr 
            curr = curr.next
        return prev
    
    def getBucket(self, key:int):
        return key % self.buckets

    
    def __init__(self):
        self.buckets = 10000 #to bring down the length of linked list we set to 10000 instead of 1000
        self.storage = [None] * self.buckets
        

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None: #if no LL present
            self.storage[bucket] = self.Node(-1,-1)
        prev = self.find(self.storage[bucket],key)
        if prev.next ==None:
            prev.next = self.Node(key,value)
        else:
            prev.next.value = value


    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(self.storage[bucket],key)
        if prev.next == None:
            return -1
        return prev.next.value

        
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return
        else:
            prev = self.find(self.storage[bucket],key)
            if prev.next == None:
                return
            prev.next = prev.next.next 


        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)