# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not any problem specific
class Node:
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.next=None
        
class MyHashMap:

    def __init__(self):
        '''Here we are implementing the HashMap as seperate chaining
        we have considered the hashtable size of 10^4'''
        self.hashtablesize=10**4
        self.table=[None for i in range(self.hashtablesize)]
        
    def hashfunction(self,key: int)->int:
        return key%self.hashtablesize
    
    '''Time complexity is O(1+r), Where r is number of elements in the linked list'''
    def put(self, key: int, value: int) -> None:
        h1=self.hashfunction(key)
        if(self.table[h1]==None):
            #Here no keys are not present in the location
            temp=Node(key,value)#Here we are creating the Node in the heap
            self.table[h1]=temp
        else:
            #Here some keys are already present in the location
            
            temp1=self.table[h1]
            while(temp1!=None):
                if(temp1.key==key):
                    #Here the key is present in the linked list, Therefore we just updated the value
                    temp1.value=value
                    return
                temp1=temp1.next
                
            #Here the key is not present in the linked list    
            temp=Node(key,value)#Here we are creating the Node in the heap
            temp.next=self.table[h1]
            self.table[h1]=temp

    '''Time complexity is O(1+r), Where r is number of elements in the linked list'''
    def get(self, key: int) -> int:
        h1=self.hashfunction(key)
        if(self.table[h1]==None):
            #Here no keys are not present in the location, Therefore the key is not present
            return -1
        else:
            temp=self.table[h1]
            while(temp!=None):
                if(temp.key==key):
                    return temp.value
                temp=temp.next
            return -1
            
    '''Time complexity is O(1+r), Where r is number of elements in the linked list'''
    def remove(self, key: int) -> None:
        h1=self.hashfunction(key)
        if(self.table[h1]==None):
            #Here no keys are not present in the location, Therefore the key is not present, Thus we no need to delete
            return -1
        else:
            prev,present=None,self.table[h1]
            while(present!=None):
                if(present.key==key):
                    break
                prev=present
                present=present.next
            #Here we have to consider three cases
            #Case 1
            if(present==None):
                #we have iterated the entire linked list but we didn't find the key
                return -1
            #Case 2,3
            if(present!=None):
                #we have found the key in the linked list
                if(prev==None):
                    #Here the key is at the head of the linked list
                    self.table[h1]=present.next
                    val=present.value
                else:
                    #Here the key is not at the head of the linked list
                    prev.next=present.next
                    val=present.value
                
                del present
                return val
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)