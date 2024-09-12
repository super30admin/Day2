// Time Complexity : O(1) for add,remove and contains.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To implement Hashset using double hashing to avoid collisions first create a 2d array of type boolean with
// size 1000*1000. But we shouldn't create nested arrays yet during declaration to make best use of memory.
// For add operation find the index and check if that index location contains an array, if not first create an
// array and then calculate the position the element goes into in the nested array and update the value as true.
// For contains operation check if the index position contains an array, if found then see if the corresponding 
// position for element in array and return coressponding boolean value. For remove first see if the index has 
// an array if present then see if the corresponding element position is true.If found true then update it to 
// false.

class MyHashSet {
    
    boolean [][] arr;
    
    public MyHashSet() {
        arr = new boolean[1000][];
    }
    
    public void add(int key) {
        if(arr[key%1000] == null && key%1000 ==0){
           arr[key%1000] = new boolean[1001]; 
        }
        else if(arr[key%1000] == null){
           arr[key%1000] = new boolean[1000];
        }
        arr[key%1000][key/1000] = true;
    }
    
    public void remove(int key) {
        if(arr[key%1000]!=null){
            arr[key%1000][key/1000] = false;
        }
    }
    
    public boolean contains(int key) {
        if(arr[key%1000]!=null){
            return arr[key%1000][key/1000];
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */