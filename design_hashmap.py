

class Node:
    
    def __init__(self,key, value, next = None):
        self.key = key 
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        self.bucket = 1000
        self.storage = [None]*self.bucket
        

    def find(self,dummy, key):
        prev = dummy 
        curr = dummy.next

        while( curr and curr.key != key):
            prev = curr
            curr = curr.next
        return prev        # time O(n)

    def get_bucket(self,key):
        return key % self.bucket


    def put(self, key: int, value: int) -> None:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            self.storage[bucket] = Node(-1, -1)
        prev = self.find(self.storage[bucket], key)   # time O(n)
        if prev.next:
            prev.next.value = value 
        else:
            prev.next = Node(key, value)



        

    def get(self, key: int) -> int:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return -1
        prev = self.find(self.storage[bucket], key)   # time O(n)
        if prev.next: 
            return prev.next.value 
        return -1

        

    def remove(self, key: int) -> None:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return 
        prev = self.find(self.storage[bucket], key) # time O(n)
        if  prev.next:
            prev.next = prev.next.next

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)