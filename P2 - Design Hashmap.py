#Approach: 
#How It Works?

    #Compute the hash index.
    #If the bucket is empty, return immediately.
    #Search for the key using find.
    #If the key exists, delete it by bypassing the node.
    #If the key doesn’t exist, return immediately.

#Time Complexity:

    #Best Case: O(1)
    #Worst Case: O(N)
    #Average Case: O(1)
 #Edge Cases Considered

#Collisions: Handled using chaining (linked lists).
# Updating Existing Keys: If the key exists, it updates instead of inserting.
# Removing Non-Existent Keys: No errors, just returns safely.
# Handling Empty Buckets: Uses sentinel node to avoid null pointer issues
class MyHashMap:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.arr = [None]*10000

    def indx(self, key):
        return key % 10000

    def find(self, head, key):
        prev = None
        curr = head
        while (curr !=None and curr.key !=key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hash_value = self.indx(key)
        if self.arr[hash_value]==None:
            self.arr[hash_value] = self.Node(-1,-1) #Iniitalize dummy node
        prev =self.find(self.arr[hash_value], key)

        if prev.next == None:
            prev.next =self.Node(key,value)
        else:
           prev.next.value = value 
        

    def get(self, key: int) -> int:
        hash_value = self.indx(key)
        if self.arr[hash_value]==None:
            return -1
        else:
            prev = self.find(self.arr[hash_value], key)
            if prev.next != None:
                return prev.next.value
            else:
                return -1


    def remove(self, key: int) -> None:
        hash_value = self.indx(key)
        if self.arr[hash_value]==None:
            return
        prev = self.find(self.arr[hash_value],key)
        if prev.next == None:
            return
        prev.next = prev.next.next
        

