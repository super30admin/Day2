class MyHashMap(object):
    def __init__(self):
        self.storage = [None]*(10000)
# deisgn hashmap using linear chaining!
    class Node(object):
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def put(self, key, value):
        # search and see if key is present- if yes- simply update the value
        new_node = self.Node(key, value)

        if self.storage[key%10000] == None:
            self.storage[key%10000] = new_node
        else:
            prev_ptr, curr_ptr = self.search(key, key%10000)
            if curr_ptr:
                curr_ptr.value = value
            if prev_ptr:
                prev_ptr.next = new_node 
        
    def get(self, key):
        prev_ptr, curr_ptr = self.search(key, key%10000)
        if curr_ptr:
            return curr_ptr.value
        else:
            return -1
        
    def remove(self, key):
        prev_ptr, curr_ptr = self.search(key, key%10000)
        #print(prev_ptr, curr_ptr.key)
        if not curr_ptr:
            return
        if not prev_ptr:
            self.storage[key%10000] = curr_ptr.next
        # if prev_ptr is None and curr_ptr.key == key%10000:
        #     self.storage[key%10000] = None
        #     return

        if curr_ptr and prev_ptr:
            prev_ptr.next = curr_ptr.next
        curr_ptr.next = None
        
    def search(self, key, idx):
        head = self.storage[idx]
        # if head is None:
        #     return None, None
        curr_ptr, prev_ptr = head, None
        while curr_ptr and curr_ptr.key != key:
            prev_ptr = curr_ptr
            curr_ptr = curr_ptr.next
        return prev_ptr, curr_ptr

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)