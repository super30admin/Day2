
########Queue using stack##########

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
1. edge case was causing issue for following entry but handled it using if else and finding the length
["MyQueue","push","pop","empty"] -> [[],[1],[],[]] 
2. While pop operation I added return in first line which exited the method so instead I stored 1st element in variable posed it and after all the action returned the result


// Your code here along with comments explaining your approach


class MyQueue:
	# took 2 stacks list1 is main stack to hold values and list2 to use to perform pop operation
    def __init__(self):
        self.list1=[]
        self.list2=[]
        
	# just used list1 to append
    def push(self, x: int) -> None:
        self.list1.append((x))

	# here used list2 to store element from 1 to end and than copying it back to mina list1
    def pop(self) -> int:
        t= self.list1[0]
        if len(self.list1)>1:
            self.list2=self.list1[1:]
            self.list1=self.list2
        else:
            self.list1=[]
        return t
        
	# just returned 1st element
    def peek(self) -> int:
        return self.list1[0]
        
	# just checked the size of list1
    def empty(self) -> bool:
        if len(self.list1)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


######hashmap without using internal hash map##########

// Time Complexity : O(1)
// Space Complexity : O(n) I already created second list of max size which has messed up my space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
1. edge case for following scenario gave issue, so handle it list2 size was incremented by 1
["MyHashMap","put","get","put","get"] -> [[],[1000000,1],[1000000],[0,2],[0]]


// Your code here along with comments explaining your approach

class MyHashMap:
	# list1 to hold keys and list2 will hold the values on the index = keys that is why the list2 size has been already defined
    def __init__(self):
        self.list1=[]
        self.list2=['x']*((10**6)+1)
        
	#check in list1 if key is present, if yes than value in list2 is updated on index=key or else key is added in lis1 and corresponding index in list2 is populated
    def put(self, key: int, value: int) -> None:
        if key not in self.list1:
            self.list1.append(key)
        self.list2[key]=value
        
	# check if key is present in list1, if present return element from list2 where index=key or else return -1
    def get(self, key: int) -> int:
        if key in self.list1:
            return self.list2[key]
        return -1
        
	#check is key is present in list1, if yes than find the index and populate with ''
    def remove(self, key: int) -> None:
        if key in self.list1:
            idx=self.list1.index(key)
            self.list1[idx]=''
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
