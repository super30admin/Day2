#Time Complexity (Average case) for get, put, is O(1) for put, get, remove
#Space Complexity is O(n)
#Used Linked List like this:  [valueKey, value, next] -> [valueKey, value, next] 
#Put them in Slots [0,1,2,.....n] n = sqrt(totalNumbers) 1000 in this case


class Node:
    def __init__(self, key, value):
        self.valueKey = key
        self.value = value
        self.next = None

class MyHashMap:  
    def __init__(self):
        self.size = 1000
        self.slots = [None] * self.size
        
    def put(self, key: int, value: int) -> None:
        hash_num = abs(int(key)) % self.size
        if self.slots[hash_num] is None:
            self.slots[hash_num] = Node(key, value)
        
        else:
            curr = self.slots[hash_num]
            while curr is not None:
                if curr.valueKey == key:
                    curr.value = value
                    #print("Key ",curr.valueKey," Updated to ",value,"\n")
                    return None
                if curr.next is None:
                    curr.next = Node(key, value)
                    return None
                curr = curr.next
    
    def traverse(self):
        i = 0 
        while i < self.size:
            printNode = 'Slot '+ str(i) + ': '
            curr = self.slots[i]
            if self.slots[i] is None:
                printNode = printNode + "None"
            else:
                while curr is not None:
                    printNode = printNode + str(curr.valueKey) + " | " + str(curr.value) + " -> "
                    curr = curr.next
            #print(printNode)
            i += 1
        #print("\n")    
        
    def get(self, key: int) -> int:
        hash_num = abs(int(key)) % self.size
        if self.slots[hash_num] is None:
            return -1

        else:
            curr = self.slots[hash_num]
            while curr is not None:
                if curr.valueKey == key:
                    return curr.value
                curr = curr.next
            return -1
        

    def remove(self, key: int) -> None:
        hash_num = abs(int(key)) % self.size
        if self.slots[hash_num] is None:
            return 
        else:
            curr = self.slots[hash_num]
            if curr.valueKey == key and curr.next is None:
                self.slots[hash_num] = None
                #print("\n", key, "removed\n")
                return None
            elif curr.valueKey == key and curr.next is not None:
                self.slots[hash_num] = curr.next

            else:
                while curr.next is not None:
                    if curr.next.valueKey == key:
                        curr.next = curr.next.next
                        #print("\n", key, "removed\n")
                        return None
                    curr = curr.next
            #print("Not Found!!")
            return None
    