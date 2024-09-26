#Time Complexity:
#Put, Get, Remove - O(N) where N is number of nodes in Linked List at a particular array index

#Space Complexity:
#In this case O(10^4) as question constraint specifies that there will be a maximum of 10^4 operations performed
#If not then O(K) where K is maximum value that a key can have

#Approach: Sep. Chaining approach where a list is initialized, each index of the list contains a Linked list to handle collisions/inserts at that index

#Accepted on Leetcode


class Node:
    def __init__(self, key, val, nextNode = None):
        self.key = key
        self.val = val
        self.nextNode = nextNode


class MyHashMap:
    
    bucketSize = 10000

    def __init__(self):
        self.bucketList = [None for i in range(MyHashMap.bucketSize)]
        
    def getBucket(self, key):
        return hash(key) % MyHashMap.bucketSize
        
    def find(self, key, bucket): #returns prev node
        listHead = self.bucketList[bucket]
        prev = cur = None
        if listHead:
            prev = listHead
            cur = listHead.nextNode
            
            while cur!= None and cur.key != key:
                prev = cur
                cur = cur.nextNode
        
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.bucketList[bucket] == None:
            self.bucketList[bucket] = Node(-1, -1)
        
        prev = self.find(key, bucket)
        if prev.nextNode:
            prev.nextNode.val = value
        else:
            prev.nextNode = Node(key, value)
        
    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.bucketList[bucket] == None:
            return -1
        
        prev = self.find(key, bucket)
        return prev.nextNode.val if prev.nextNode else -1
        
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        
        if self.bucketList[bucket]:
            prev = self.find(key, bucket)
            if prev.nextNode:
                prev.nextNode = prev.nextNode.nextNode
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)