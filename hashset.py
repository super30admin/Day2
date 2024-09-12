"""
Tc: O(n)
SC: O(n)

"""



class MyHashSet:

    def __init__(self):
        self.main=1000
        self.second=1000
        self.main_arr=[None]*self.main
        
    def get_main_arr_index(self,key):
        return key%1000
    
    def get_second_arr_index(self,key):
        return key//1000
        
        

    def add(self, key: int) -> None:
        main_index=self.get_main_arr_index(key)
        second_index=self.get_second_arr_index(key)
        if not self.main_arr[main_index]:
            if main_index == 0:
                self.main_arr[main_index] = [False]*(self.second+1)
            else:
                self.main_arr[main_index] = [False]*(self.second)
                
        self.main_arr[main_index][second_index] = True          
            
    def remove(self, key: int) -> None:
        main_index=self.get_main_arr_index(key)
        second_index=self.get_second_arr_index(key)
        if not self.main_arr[main_index]:
            return 
        self.main_arr[main_index][second_index] = False
            
    def contains(self, key: int) -> bool:
        main_index=self.get_main_arr_index(key)
        second_index=self.get_second_arr_index(key)
        if not self.main_arr[main_index]:
            return False
        else:
            if self.main_arr[main_index][second_index]==False:
                return False
        return True
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)