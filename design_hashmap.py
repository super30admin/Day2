class MyHashMap(object):

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def get_hash(self, key):
        return key % self.buckets

    def get_prev(self, head, key):
        # here head is (-1,-1) which is first assigned when the first put function is given as input
        prev = None
        curr = head
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_key = self.get_hash(key)
        if self.storage[hash_key] is None:
            self.storage[hash_key] = MyHashMap.Node(-1, -1)
        prev = self.get_prev(self.storage[hash_key], key)
        if prev.next is None:
            prev.next = MyHashMap.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key):

        hash_key = self.get_hash(key)
        if self.storage[hash_key] is None:
            return -1
        prev = self.get_prev(self.storage[hash_key], key)
        if prev.next is None:
            return -1
        else:
            return prev.next.value

    def remove(self, key):

        hash_key = self.get_hash(key)
        if self.storage[hash_key] is None:
            return
        prev = self.get_prev(self.storage[hash_key], key)
        if prev.next is None:
            return
        curr = prev.next
        prev.next = prev.next.next
        curr.next = None


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 100)
obj.put(2, 200)
param_2 = obj.get(1)
obj.remove(1)
print(param_2)

# best case time complexity of get_hash, get_prev,put, get and remove functions is O(1)
# space complexity is O(n) if one node exists per bucket
