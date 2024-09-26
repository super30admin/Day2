// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;
//I have declared size for hash box which is max_val and array size
//one parent list
// approach is to generate parent arraylist and assigning index using key % arraysize which 1000000 
class MyHashSet {
     private final int Max_Value = 1000000;
     private final int array_size = 100;
    private  List<List<Integer>> parentList;
    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(array_size);
        for(int i =0; i<array_size; i++){
            parentList.add(null);
        }
    }
    //childlist is empty the linkedlist is added with that key and in prentlist the ky and index is updated and if the key is not present in childlist, we need to add it
    public void add(int key) {
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList == null){
           List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        }else{
            if(!childList.contains(key)){
                childList.add(key);
            }
        }
    }
    //we calculate the value of index using the key and get the data from parentlist at that index and then remove the value of that key from childlist
    public void remove(int key) {
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }
    }
    //it returns true if the childlist is not empty and contains the key
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}
