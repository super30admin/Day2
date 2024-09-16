// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
# creating a new node
class listNode:                 

    def __init__(self, data, next=None):
        self.data=data
        self.next=next


class queue:


    def __init__(self):
        self.head=None
        self.end=None
    
    #pushing a new element at end of the queue
    def push(self, data):
        if self.head==None:           #if queue is empty
            self.head= listNode(data)
            self.end=self.head
        else:                         #if queue is not empty
            self.end.next=listNode(data)
            self.end=self.end.next
    #removing from element
    def pop(self):
        if self.head==None:  #if queue is empty, jsut return
            return
        else:                #else point to the next node
            self.head=self.head.next
    
    def peek(self):
        return self.head.data
    
    def empty(self):
        if self.head==None:
            return True
        else:
            return False
    
    def printQueue(self):
        temp=self.head
        while(temp!=None):
            print(temp.data)
            temp=temp.next

queue1= queue()
queue1.push(1)
queue1.push(2)
queue1.push(3)


queue1.pop()
queue1.printQueue()
print(queue1.peek())
print(queue1.empty())

    

                
                
                
                
class MyHashSet(object):

    def __init__(self):

        self.keyRange = 1000
        self.bucketArray = [Bucket() for i in range(self.keyRange)]

    def _hash(self, key):
        return key % self.keyRange

    def add(self, key):

        bucketIndex = self._hash(key)
        self.bucketArray[bucketIndex].insert(key)

    def remove(self, key):

        bucketIndex = self._hash(key)
        self.bucketArray[bucketIndex].delete(key)

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        """
        bucketIndex = self._hash(key)
        return self.bucketArray[bucketIndex].exists(key)


class Node:
    def __init__(self, value, nextNode=None):
        self.value = value
        self.next = nextNode

class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        # if not existed, add the new element to the head.
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.next)
            # set the new head.
            self.head.next = newNode

    def delete(self, value):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                # remove the current node
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def exists(self, value):
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                # value existed already, nothing to do
                return True
            curr = curr.next
        return False
        
#driver code
hashset = MyHashSet()
hashset.add(key)
hashset.remove(key)
print(hashset.contains(key))
