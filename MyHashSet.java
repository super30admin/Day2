// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    private static final int HASH = 560;

    List<List<Integer>> HashSet = new ArrayList<>();

    MyHashSet(){
        for(int i = 0; i < HASH; i++)
            HashSet.add(null);
    }

    public void add(int key) {
        if(!contains(key)){
            List<Integer> add = new ArrayList<>();
            add.add(key);
            HashSet.set(getIndex(key), add);
        }else{
            List<Integer> get = HashSet.get(getIndex(key));
            get.add(key);
        }
    }

    private Integer getIndex (int key) {
        return key % HASH;
    }

    public void remove(int key) {
        List<Integer> child = HashSet.get(getIndex(key));
        if(child != null)
            HashSet.remove(key);
    }

    public boolean contains(int key) {
        return HashSet.get(getIndex(key)) != null;
    }

    public void print(){
        System.out.println();
        for(List<Integer> key : HashSet)
            if (key != null)
                System.out.println(key);

    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.print();
        obj.add(2);
        obj.print();
        obj.add(2);
        obj.print();
        obj.remove(2);
        boolean param_3 = obj.contains(2);

        System.out.println(param_3);
    }
}