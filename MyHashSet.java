
// Time Complexity O(n)
//Space Complexity O(n)

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    int MAX_VALUE=100000;
    int ARRAY_SIZE=100;
    List<List<Integer>> parentList;

    public MyHashSet() {

        parentList = new ArrayList<>(ARRAY_SIZE);

        for(int i=0;i<=parentList.size();i++){
            parentList.add(null);
        }

    }

    public void add(int key) {

        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);

        if(childList == null){
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            parentList.set(index,temp);

        }else{

            if(!childList.contains(key)){
                childList.add(key);
            }

        }

    }

    public void remove(int key) {

        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);

        if(childList!=null){
            childList.remove(Integer.valueOf(key));
        }

    }

    public boolean contains(int key) {

        int index = key%ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);

        if(childList!=null){

            return childList.contains(key);
        }else{
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