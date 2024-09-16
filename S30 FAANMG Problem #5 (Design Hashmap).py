# Time Complexity : O(1)

class Hashmap:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.buckets = [None] * 100000

    def hashfunction(self, key):
        return key % 100000

    def find(self, headnode, key):
        temp = headnode
        if temp.next is not None and temp.next.key != key:
            temp = temp.next
        return temp

    def put(self, key, value):
        idx = self.hashfunction(key)
        if self.buckets[idx] is None:
            self.buckets[idx] = Hashmap(-1, -1)

        # find is node is present
        prev = self.find(self.buckets[idx], key)

        if prev.next is None:
            # key not present at the idx
            prev.next = Hashmap(key, value)
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


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)