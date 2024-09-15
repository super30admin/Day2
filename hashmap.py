#time complexity: every function uses find() function which has a max O(100) complexity so it can be said as constant compared to 10^6
#space complexity: O(n) space used for every element
#passed all cases on LeetCode:yes
#difficulty faced: i had/have a huge confusion about passing a node to the function find() inside the class HashMap
# comments: all the functions get() put() and remove() are consistent with this approach
#leetcode: https://leetcode.com/problems/design-hashmap/submissions/

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.nodes = [None]*self.buckets
        
    
    def getbuckets(self, key:int) -> int:
        return key%self.buckets
    
    def find(self,key):
        newbucket = self.getbuckets(key)
        node = self.nodes[newbucket]
        prev = node
        curr = node.next 
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        newbucket = self.getbuckets(key)
        #the array index doesnt even exist
        if self.nodes[newbucket] == None:
            #decided to have 1st node as a dummy node with -1,-1 because we dont have to check for head everytime if we have to remove the head node and each function is consistent
            self.nodes[self.getbuckets(key)] = Node(-1, -1)
        prev = self.find(key)
        #node does not exist
        if prev.next == None:
            prev.next = Node(key,value)
        else:
            prev.next.value = value
                
            
    def get(self, key: int) -> int:
        newbucket = self.getbuckets(key)
        if self.nodes[newbucket] == None:
            return -1
        prev = self.find(key)
        if prev.next == None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        newbucket = self.getbuckets(key)
        if self.nodes[newbucket] == None:
            return 
        prev = self.find(key)
        if prev.next == None:
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)