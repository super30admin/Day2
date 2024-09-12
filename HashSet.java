//Exercise_2 : Design HashSet
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: I used ArrayList and LinkedList Data Structure. Here, my  idea is to fix a array size of 100 and then create a List of List which means there will be a parent list and inside parent list there will be a child list for each index of the parent list. Whenever a key is inserted hashing of the key will be done using modulo (%) ARRAY_SIZE for finding the index of the parent list where key is going to be stored.However I will not directly store the key on that index because further there could be a collison and to prevent that collision I will use the concept of Linear Chaining using LinkedList as the child list. Once the index is found of the parent list then the key will be stored at the first index of the child list which is linked list. I'm storing the key in the first index of the child list so that the code could be little optimized because everytime when a key is added and there is a child list at the specific parent list index, then contains will be called first to check whether child list has that key or not. This is going to take O(n) TC and then if key not exist and I have to insert the key in last then again linkedlist will traverse the whole list which results into TC O(n).Therefore overal TC for insertion will be O(n)+O(n) That why I'm always inserting the key in child list at first index so that TC will be O(1). Thus, overall TC for the insertion will be will be O(n)+O(1); 

/**** Steps ****/
/*
 1) Declare ARRAY_SIZE of 100 and list of list called parent list
 2) In the constructor initialize the parent list with null because initially the parent list is empty and while add , remove and contain operations we can check whether specific index of the childList is null or not and can proceed accordingly.
 3) Add -> Find the 'index' by using hashing technique which is key % array_size. If child list is not there in that index, then create a new list object. Add the key and then 'set' that child object in the index of the parent list. Never use add for adding the child list object into parent list here in this case. Because "'set' will add the new element at specified position by replacing the older element at that position. whereas 'add' shifts the existing element to the right side for adding element on a specific index".
 4) Remove - Find the index of the key using the same hashing technique used with add operation and check whether that index has child list or not. If it has the child list, use list 'contains' method and then use 'remove' method by passing "Integer.valueOf() or new Integer()" function. Then only value can be removed. If u will directly pass the value in the remove function, then remove will try to remove the index not the value.
 5) Contains -  Find the index of the key using the same hashing technique used with add operation and check whether that index has child list or not. If it has the child list, use list contains method and return the result.
*/

import java.util.*;

class MyHashSet {
    
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            parentList.add(null);
        }
       
    }
    
    public void add(int key) {
        int index = key%ARRAY_SIZE;
        
        List<Integer> childList = parentList.get(index);
        
        if(childList==null){
            childList  = new LinkedList<>();
            childList.add(0,key);// Adding on first index so that insertion couldbe O(1);
            parentList.set(index,childList);//will add the new element at specifiec position by replacing the older element at that position. whereas add shifts the existing element to the right side for adding element on a specific index
        }else{
            if(!childList.contains(key)){
                childList.add(0,key);// Adding on first index so that insertion could be O(1);
            }
        }
    }
    
    public void remove(int key) {
        
        int index = key%ARRAY_SIZE;
        
        List<Integer> childList = parentList.get(index);
        if(childList!=null){
            
            if(childList.contains(key)){
                childList.remove(Integer.valueOf(key));
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int index = key%ARRAY_SIZE;
        
        List<Integer> childList = parentList.get(index);
        
        if(childList!=null){
            
            return childList.contains(key);
        }
        
        return false;
    }
}

