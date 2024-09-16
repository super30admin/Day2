# Time Complexity: O(100) - Constant
# Space Complexity: O(N)
# Any problem you faced while coding this : No
# Did this code successfully run on Leetcode: Yes

class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap(object):

    def __init__(self):
        self.bucket = 1000
        self.storage = [None]*self.bucket
        
    def getHash(self, key):
        return key%self.bucket
    
    def find(self, node, key):
        prev = node
        
        curr = node.next
        
        while curr!=None and curr.key!=key:            
            prev = curr
            curr = curr.next
            
        return prev
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket = self.getHash(key)
        
        if(self.storage[bucket] == None):
            self.storage[bucket] = Node(-1,-1)
            
        #find the node
        prev = self.find(self.storage[bucket], key)
        print(prev)
        if (prev.next==None):
            #key doesn't exists
            prev.next = Node(key, value)
        else:
            #key exists
            prev.next.value = value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket = self.getHash(key)
        if (self.storage[bucket] == None):
            return -1
        prev = self.find(self.storage[bucket], key)
        if (prev.next == None):
            return -1
        else:
            return prev.next.value

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getHash(key)
        if (not self.storage[bucket]):
            return
        prev = self.find(self.storage[bucket], key)
        if prev.next == None:
            return
        else:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)