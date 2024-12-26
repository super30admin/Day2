class MyHashMap:
    # Double Hashing Method
    # TC - O(1) for every operation
    # def __init__(self):
    #     self.bucket = 1000
    #     self.bucketItem = 1000
    #     self.storage = [None] * self.bucket

    # def getbucket(self,key):
    #     return key%1000

    # def getbucketItem(self,key):
    #     return key//1000        
        

    # def put(self, key: int, value: int) -> None:
    #     bucketIndex = self.getbucket(key)
    #     bucketItemIndex = self.getbucketItem(key)

    #     if self.storage[bucketIndex] == None:
    #         if bucketIndex == 0:
    #             self.storage[bucketIndex] = [-1] * (self.bucketItem + 1)
    #         else:
    #             self.storage[bucketIndex] = [-1] * self.bucketItem
    

    #     self.storage[bucketIndex][bucketItemIndex] = value    

        

    # def get(self, key: int) -> int:
    #     bucketIndex = self.getbucket(key)
    #     bucketItemIndex = self.getbucketItem(key)

    #     if self.storage[bucketIndex] == None:
    #         return -1
    #     return  self.storage[bucketIndex][bucketItemIndex]    

        

    # def remove(self, key: int) -> None:
    #     bucketIndex = self.getbucket(key)
    #     bucketItemIndex = self.getbucketItem(key)
    #     if self.storage[bucketIndex] == None:
    #         return 
    #     self.storage[bucketIndex][bucketItemIndex] = -1  


    # LinkedList operation
    class Node:
        def __init__(self,key, value):
            self.key = key
            self.data = value
            self.next = None

    def __init__(self):
        self.bucket = 1000
        self.storage = [None] * self.bucket 

    def getBucketIndex(self, key):
        return key%1000
    
    def find(self, dummy, key):
        prev = dummy
        current = dummy.next

        while current!=None and current.key!=key:
                prev = current
                current = current.next
        return prev # prev.next would be the key or None as we came at the end of linkedlist so the value is not there present 


    def put(self, key: int, value: int) -> None:
        bucketIndex = self.getBucketIndex(key)

        if self.storage[bucketIndex] == None:
            self.storage[bucketIndex] = self.Node(-1,-1)

        prev =  self.find(self.storage[bucketIndex],key)

        if prev.next == None:
            prev.next = self.Node(key,value)
        else:
            prev.next.data = value     

    def get(self, key: int) -> int:
        bucketIndex = self.getBucketIndex(key) 
        if self.storage[bucketIndex] == None:
            return -1
        prev =  self.find(self.storage[bucketIndex],key)
        if prev.next == None:
            return -1
        else:
            return prev.next.data 

    def remove(self, key: int) -> None: 
        bucketIndex = self.getBucketIndex(key) 
        if self.storage[bucketIndex] == None:
            return
        prev =  self.find(self.storage[bucketIndex],key)
        if prev.next == None:
            return 
        else:
            prev.next = prev.next.next       

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
