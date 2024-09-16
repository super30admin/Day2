// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    /** Initialize your data structure here. */
    List<Container> mainList;
    int capacity = 769;

    public MyHashSet() {
        mainList = new ArrayList<>();
        for(int i=0; i<=capacity; i++){
            mainList.add(i, new Container());
        }
    }

    public void add(int key) {
        int position = new Integer(key).hashCode();
        position = position%capacity;

        Container myContainer = mainList.get(position);

        if(myContainer == null){
            Container newContainer = new Container();
            newContainer.add(key);
            mainList.add(position,newContainer);
        }else{
            myContainer.add(key);
        }

    }

    public void remove(int key) {
        int position = (new Integer(key).hashCode())%capacity;
        Container myContainer = mainList.get(position);

        if(myContainer == null){
            return;
        }else{
            myContainer.remove(key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = (new Integer(key).hashCode())%capacity;
        Container myContainer = mainList.get(position);

        if(myContainer == null){
            return false;
        }else{
            return myContainer.contains(key);
        }
    }

    class Container{
        List<Integer> entries = new LinkedList<>();

        public void add(int value){
            for(Integer entry: entries){
                if(entry.intValue() == value){
                    return;
                }
            }
            entries.add(new Integer(value));
        }

        public boolean contains(int value){
            for(Integer entry: entries){
                if(entry.intValue() == value){
                    return true;
                }
            }
            return false;
        }

        public void remove(int value){
//              for(Integer entry: entries){
//                 if(entry.intValue() == value){

//                 }
            entries.remove(new Integer(value));
        }

    }
}
