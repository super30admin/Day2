// Time Complexity : adding,removing takes o(1),
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this : yes, fcing problem to add linkedlist at specified index in an array by using inbuilt functions.


// Your code and explanantion: initialy at indeces of arrays inserted values based on remainder. if collusion occurs at that index linkedlist is created and removed or put is done in linked list.

import java.util.*;
class MyHashMap {
    LinkedList<Integer> ll= new LinkedList<Integer>();

    /** Initialize your data structure here. */
    int[] a;
    int max;
    int t;
    
    public MyHashMap() {
        max=1000000;
        a=new int[max];
        t=10000;
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int m=key%t;
        if(a[m]==0){
            a[m]=value;
        }
        else{
            a[m]=ll.add(value);
            
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int y=key%t;
        if(a[y]==0){
            return -1;
        }
        else{
          int n=ll.get(0) ;
        return n;
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ll.remove( get(key));
        
    }
}

