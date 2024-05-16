'''
HashMap with separate chaining solution

Time Complexity :
  put: O(n) in worst case
  get: O(n) in worst case
  remove: O(n) in worst case
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach

'''

class Node:
  def __init__(self, key=None, value=None):
    self.key = key
    self.value = value
    self.next = None

class MyHashMap:

  def __init__(self):
    self.numberOfBuckets = 1000
    self.storage = [Node()] * self.numberOfBuckets

  def getBucket(self, key):
    return key % self.numberOfBuckets

  # if the key exists, it returns the previous node of the node containing the key
  # else it returns the last node of the linked list in that bucket
  def getPreviousNode(self, key):
    bucket = self.getBucket(key)
    prevNode = self.storage[bucket]
    currNode = prevNode.next
    while currNode and currNode.key != key:
      prevNode = currNode
      currNode = currNode.next
    return prevNode

  def put(self, key: int, value: int) -> None:
    prevNode = self.getPreviousNode(key)
    if prevNode.next: # the key exists in the next node, update the value
      prevNode.next.value = value
    else: # the key does not exist in the bucket, put a new node with the key, value
      newNode = Node(key, value)
      prevNode.next = newNode

  def get(self, key: int) -> int:
    prevNode = self.getPreviousNode(key)
    if prevNode.next: # the key exists in the next node, return the value
      return prevNode.next.value
    return -1 # the key does not exist in the bucket, return -1

  def remove(self, key: int) -> None:
    prevNode = self.getPreviousNode(key)
    if prevNode.next: # the key exists in the next node, de-link that node from the linked list
      prevNode.next = prevNode.next.next

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
print('put 52, 5345')
obj.put(52, 5345)
print('put 45, 78878')
obj.put(45, 78878)
print('put 545, 890808')
obj.put(545, 890808)
print('put 6577, 343')
obj.put(6577, 343)
print('get 45:', obj.get(45))
print('get 545:', obj.get(545))
print('get 354:', obj.get(354))

print('put 545, 4')
obj.put(545, 4)
print('get 545:', obj.get(545))

print('Remove 45')
obj.remove(45)
print('put 354, 10009')
obj.put(354, 10009)
print('get 45:', obj.get(45))
print('get 354:', obj.get(354))

print('put 1000000, 5456')
obj.put(1000000, 5456)
print('put 999999, 66711')
obj.put(999999, 66711)
print('get 1000000:', obj.get(1000000))
print('get 999999:', obj.get(999999))

print('put 1000000, 90')
obj.put(1000000, 90)

print('Remove 999999')
obj.remove(999999)
print('get 1000000:', obj.get(1000000))
print('get 999999:', obj.get(999999))