"""
706.Design a HashMap without using any built-in hash table libraries.
Implement the MyHashMap class:
MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
Constraints:
0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.

Time complexity - O(1)
Space Complexity - O(1)

Approach--
1. Put
- Check if LL is present at the found hash idx. If not, create a LL and assign a dummy node (-1,-1)
- 'Find' if key is present at the idx value, if not add it
- If the key is present replace the value

2. Find
- Assign headnode to tempnode.
- While tempnode is not None and while tempnode key is not equal to key, traverse to next node
- return if tempnode found

3. Get
- Check if LL is present at the idx. if no, return -1
- 'Find' if key is present at idx
- If on traversal key is not found, return -1
- else return corresponding key's value
"""


class LNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    def __init__(self):
        self.buckets = [None] * 10000

    def hashfunction(self, key):
        return key % 10000

    def find(self, headnode, key):
        tempNode = headnode
        if tempNode.next is not None and tempNode.next.key != key:
            tempNode = tempNode.next
        return tempNode

    def put(self, key, value):
        idx = self.hashfunction(key)
        if self.buckets[idx] is None:
            self.buckets[idx] = LNode(-1, -1)

        # find is node is present
        prev = self.find(self.buckets[idx], key)

        if prev.next is None:
            # key not present at the idx
            prev.next = LNode(key, value)
        else:
            # key is present so replace value
            prev.next.value = value

    def get(self, key):
        idx = self.hashfunction(key)
        # check if LL is present
        if self.buckets[idx] is None:
            return -1

        prev = self.find(self.buckets[idx], key)
        if prev.next is None:
            return -1
        else:
            return prev.next.value

    def remove(self, key):
        idx = self.hashfunction(key)
        # check if LL is present
        if self.buckets[idx] is None:
            return -1
        prev = self.find(self.buckets[idx], key)
        if prev.next is None:
            return -1
        else:
            prev.next = prev.next.next

obj = MyHashMap()
obj.put(3,20)
obj.put(0,4)
obj.put(0,24)
obj.put(5,11)
obj.put(5,21)
print(obj.get(0))
print(obj.remove(5))