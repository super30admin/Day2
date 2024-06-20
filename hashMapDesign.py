'''
Time Complexity 

put --> O(n) in worst case
get --> O(n) in worst case
remove --> O(n) in worst case

Space complexity

O(n) since we are using linked List to takle collision

Approach
1. Create a primary array of size 10**4
2. Creat the hash function and return thge index
3. If collison happens cerate linked list with on same index
4. if key already present updated the value

'''


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        
        self.primary_array = [None for i in range(10**4)]
        
        

    def Hashfunction(self, key):
        return key%10**4
    
    def put(self, key: int, value: int) -> None:
        index = self.Hashfunction(key)
        if self.primary_array[index] == None:
            newNode = Node(key, value)
            self.primary_array[index] = newNode
        else:
            curr = self.primary_array[index]
            prev = curr
            while curr:
                if curr.key == key:
                    curr.value = value
                    return
                else:
                    prev = curr
                    curr = curr.next
            prev.next = Node(key, value)
                    
            
            
            
        
        

    def get(self, key: int) -> int:
        index = self.Hashfunction(key)
        if self.primary_array[index] == None:
            return -1
        else:
            curr = self.primary_array[index]
            while curr:
                if curr.key == key:
                    return curr.value
                curr = curr.next
            return -1
        
        
        

    def remove(self, key: int) -> None:
        index = self.Hashfunction(key)
        if self.primary_array[index] == None:
            return -1
        else:
            curr = self.primary_array[index]
            prev = curr
            if curr.key == key:
                self.primary_array[index] = prev.next
                return
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = prev.next.next
                    break
                prev = curr
                curr = curr.next
                
            return
            
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)