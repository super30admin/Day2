# time complexity: O(1)
# space complexity: O(n)

class Node(object):  # initialize Node([Key,value],next)
    def __init__(self, val):
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        self.size = 100000
        self.array = [None] * self.size  # make array of [size]positions

    def calculate_hv(self, key):  # calculate hash value
        return key % self.size

    def put(self, key: int, value: int) -> None:
        hv = self.calculate_hv(key)  # calculate hash value
        print(key, "v:", value)
        # print(self.array[hv])
        if self.array[hv] == None:  # if array[hv]is empty
            self.array[hv] = Node([key, value])  # then assign Node to that position
            tem = self.array[hv]
            # print(Node([key, value]).val[0])
            # print(self.array[hv])
        else:
            prev = temp = self.array[hv]
            while temp != None:  # search for key and put the value at key
                if temp.val[0] == key:
                    temp.val[1] = value
                    return
                prev = temp
                temp = temp.next

            prev.next = Node([key, value])

    def get(self, key: int) -> int:
        hv = self.calculate_hv(key)  # calculate hash value

        temp = self.array[hv]
        while temp != None:
            if temp.val[0] == key:          # search for key and get the value at key
                return temp.val[1]
            temp = temp.next
        return -1

    def remove(self, key: int) -> None:
        hv = self.calculate_hv(key)  # calculate hash value
        curr = prev = self.array[hv]

        if curr != None and curr.val[0] == key and curr.next == None:
            self.array[hv] = None
            return

        while curr != None:

            if curr.val[0] == key:
                temp = curr.next
                prev.next = temp
                del curr
                return

            prev = curr
            curr = curr.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)