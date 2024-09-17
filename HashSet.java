// Time Complexity : O(N) for searching and remove. O(1) for insertion as I am adding new elemnet at head.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.List;

class HashSet {
    
    List<Integer>[] data;
    /** Initialize your data structure here. */
    int size = 1000;
    public HashSet() {
        data = new List[size];
        for(int i = 0 ; i <data.length;i++)
        {
            data[i] = new LinkedList<>();
        }
    }
    private int hashFunction(int key)
    {
        return key%size;
    }
    private List findElement(int key)
    {
        int index = hashFunction(key);
        return data[index];
    }
    public void add(int key) {
        List l = findElement(key);
        if(l.indexOf(key)!=-1)
            return;
        l.add(0,key);
    }
    
    public void remove(int key) {
        List el = findElement(key);
        if(el.indexOf(key)==-1)
            return;
        el.remove(el.indexOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       return findElement(key).indexOf(key)!=-1;
    }
}