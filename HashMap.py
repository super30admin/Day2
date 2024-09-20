#Time Complexity = O(1) Space Complexity = O(1)

class Node:

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.b_size = 10000
        self.buckets = [None for i in range(10000)]

    def get_index(self, key: int) -> int:
        return key % self.b_size

    def get_elem(self, key: int):
        index = self.get_index(key)
        if self.buckets[index] is None:
            dummy_node = Node(-1, -1)
            self.buckets[index] = dummy_node
            return dummy_node

        current_node = self.buckets[index]

        while current_node.next is not None:
            if current_node.next.key == key:
                return current_node
            current_node = current_node.next

        return current_node

    def put(self, key: int, value: int) -> None:
        current_node = self.get_elem(key)
        if current_node.next is None:
            current_node.next = Node(key, value)
        else:
            current_node.next.value = value
        return

    def get(self, key: int) -> int:
        current_node = self.get_elem(key)
        if current_node.next is None:
            return -1
        else:
            return current_node.next.value

    def remove(self, key: int) -> None:
        current_node = self.get_elem(key)
        if current_node.next is not None:
            current_node.next = current_node.next.next
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)