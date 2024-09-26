# Using Separate Chaining technique

class Node:

    def __init__(self, data):
        self.data = data
        self.next = None

class LL:

    def __init__(self):
        self.head = None

    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def add(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next is not None:
                temp = temp.next
            temp.next = new_node

class MyHashMap(object):

    # Space Complexity: O(n)
    def __init__(self):
        self.n_buckets = 10 ** 4

        # 10**2 to limit length of LL so that traversal time reduces.
        self.n_nodes = 10 ** 2 + 1  # +1 as we are adding a dummy node
        self.prim_arr = [None] * self.n_buckets

    # Time Complexity: O(n), n=100
    # Space Complexity: O(n)
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_ind = key % self.n_buckets
        if self.prim_arr[hash_ind] is None:
            self.prim_arr[hash_ind] = LL()
            self.prim_arr[hash_ind].add([-1, -1])   # dummy node so that we don't have to deal with head case separately
            self.prim_arr[hash_ind].add([key, value])
        else:
            temp = self.prim_arr[hash_ind].head
            flag = False
            while temp is not None:
                if temp.data[0] == key:
                    flag = True
                    temp.data[1] = value
                temp = temp.next
            if flag == False:
                self.prim_arr[hash_ind].add([key, value])

    # Time Complexity: O(n), n=100
    # Space Complexity: O(1)
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hash_ind = key % self.n_buckets
        if self.prim_arr[hash_ind] is None:
            return -1
        else:
            temp = self.prim_arr[hash_ind].head
            while temp is not None:
                if temp.data[0] == key:
                    return temp.data[1]
                temp = temp.next
            return -1

    # Time Complexity: O(n), n=100
    # Space Complexity: O(1)
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_ind = key % self.n_buckets
        if self.prim_arr[hash_ind] is not None:
            temp = self.prim_arr[hash_ind].head
            while temp.next is not None:
                if temp.next.data[0] == key:
                    temp.next = temp.next.next
                    return
                temp = temp.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)