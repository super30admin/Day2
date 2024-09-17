
// Time Complexity : O(N) {Worst case}
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    //Setting the max value to 100
    private final int MAX = 100;
    //Idea of using nested list is to store one for parent(ArrayList) and another for child(bucket value)(Linked List)
    private List<List<Integer>> parent_list;

    public MyHashSet() {
        parent_list = new ArrayList<>(MAX);
        for(int i=0; i<MAX; i++)
            parent_list.add(null);
    }

    public void add(int key) {
        //Using modulo to store the key within the limited Index (MAX value)
        int index = key % MAX;
        List<Integer> child_list = parent_list.get(index);
        //If list is null, create new linked list
        if(child_list == null){
            LinkedList<Integer> temp_list = new LinkedList<>();
            temp_list.add(key);
            parent_list.set(index, temp_list);
        } else {
            // If my child list does not contain key, simply add it
            if(!child_list.contains(key))
                child_list.add(key);
        }
    }

    public void remove(int key) {
        int index = key % MAX;
        List<Integer> child_list = parent_list.get(index);
        if(child_list != null)
            //Using remove(obj) to remove the first occurence of the element
            child_list.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = key % MAX;
        List<Integer> child_list = parent_list.get(index);

        //child_list should not be null and if contains the key
        return child_list!=null && child_list.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // return True
        hashSet.remove(2);   // set = [1]
        System.out.println(hashSet.contains(2)); // return False, (already removed)
    }
}
