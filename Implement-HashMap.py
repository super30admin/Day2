# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#I was having difficutly solving this problem using linked_list and to apply the concept of bucket
#Therefore I used the list method. The get function's complexity will be O(n) worst case.

#But, even after using List this solution  is working on Leetcode



class MyHashMap:

    def __init__(self):
        self.l=[-1 for _ in range(1000000)]

    def put(self, key: int, value: int) -> None:
        self.l[key]=value

    def get(self, key: int) -> int:   #O(n)
        return self.l[key]

    def remove(self, key: int) -> None:
        self.l[key]=-1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)