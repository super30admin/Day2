"""


Topics
Companies
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

Time Complexity:
- put(): O(N) in the worst case (when all keys collide in the same bucket), O(1) on average.
- get(): O(N) in the worst case, O(1) on average.
- remove(): O(N) in the worst case, O(1) on average.

Space Complexity:
- O(N), where N is the number of stored key-value pairs.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# 1. implemented a hash map using separate chaining with linked lists to handle collisions efficiently.
# 2. The hash function determines an index, and each bucket is a linked list where stored key-value pairs.
# 3. For insertion, retrieval, and deletion, traversed the linked list to find the key, updating or removing it accordingly.

class MyHashMap:
    class Node:
        def __init__(self, key=None, value=None, next=None):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.arr = [None] * 10000

    def hash1(self, key):
        return key % len(self.arr)

    def find(self, head, key):
        prev = None
        curr = head
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.hash1(key)
        if self.arr[index] is None:
            self.arr[index] = self.Node(-1, -1, None)

        prev = self.find(self.arr[index], key)
        if prev.next is None:
            prev.next = self.Node(key, value, None)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        index = self.hash1(key)
        if self.arr[index] is None:
            return -1
        else:
            prev = self.find(self.arr[index], key)
            if prev.next is None:
                return -1
            else:
                return prev.next.value

    def remove(self, key: int) -> None:
        index = self.hash1(key)
        if self.arr[index] is None:
            return

        prev = self.find(self.arr[index], key)
        if prev.next is None:
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)



