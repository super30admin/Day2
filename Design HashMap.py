# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class MyHashMap:
 
    def __init__(self):
        self.hashmap = [None] * 1000
    
    def _hash(self,data):
        return hash(data) % 1000

    def put(self, key: int, value: int) -> None:
        block = self._hash(key)
        if self.hashmap[block] is None:
            self.hashmap[block] = Node((key,value))
        else:
            curr = self.hashmap[block]
            while curr:
                k, v = curr.data
                if k == key:
                    curr.data = (key,value)
                    return
                if curr.next is None:
                    break
                else:
                    curr = curr.next
            curr.next = Node((key,value))

    def get(self, key: int) -> int:
        block = self._hash(key)
        if self.hashmap[block] is None:
            return -1
        curr = self.hashmap[block]
        while curr:
            k, v = curr.data
            if k == key:
                return v
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        block = self._hash(key)
        if  self.hashmap[block] is None:
            return 
        curr = self.hashmap[block]
        temp = Node(0)
        temp.next = curr
        
        current = temp
        while current and current.next:
            k, v = current.next.data
            if k == key:
                current.next = current.next.next
            current = current.next
        self.hashmap[block] = temp.next

if __name__ == "__main__":

	hashMap = MyHashMap()
	hashMap.put(1, 1)
	hashMap.put(2, 2)
	print(hashMap.get(1))
	print(hashMap.get(3))
	print(hashMap.get(2))
	hashMap.put(2, 1)
	print(hashMap.get(2))
	hashMap.remove(2)
	print(hashMap.get(2))

