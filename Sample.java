// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*
@auther = PRAYAG PATEl
@Problem = S30 FAANMG Problem #1{easy}, leetcode 705.Design Hash {easy}
@asked = PayPal
*/

/**@approach : intializing an array only with one parameter
 * Second parameter of array passed while adding
 * hash function 1:key%1000 hash function 2:key/1000
 */

class MyHashSet {
    public int i ;
    public int [][] Set;

    public MyHashSet() {
        this.i=1000;
        this.Set = new int [i][];
    }
    
    public void add(int key) {
        int index = key%1000;
        if(Set[index] == null){
            Set[index] = new int [1000];
        }
        if(Set[index][key/1000]==key){
            System.out.print("element already added\n");
        }
        Set[index][key/1000]=key;
    }
    
    public void remove(int key) {
        int index = key%1000;
        if(Set[index].length == 0){
            System.out.print("element not found");
            return;
        }
        if(Set[index][key/1000] == 0){
            System.out.print("element not found");
            return;
        }
        Set[index][key/1000] = -1;
    }
    
    public boolean contains(int key) {
        int index = key%1000;
        if(Set[index]== null){
            System.out.print("element not found \n");
            return false;
        }
        if(Set[index][key/1000] == 0){
            System.out.print("element not found \n");
            return false;
        }
        if(Set[index][key/1000] == -1){
            System.out.print("element removed \n");
            return false;
        }
        System.out.print("element found \n");
        return true;
        
    }

     public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
        }
 }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


