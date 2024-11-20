// Time complexity is O(1+lf), depends on the Load factor(lf): lf = n/m, n=number of elements stored in hash table and m=number of slots
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes (https://leetcode.com/submissions/detail/567066705/)
// Any problem you faced while coding this:

import java.util.*;
class MyHashSet {
    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    List<List<Integer>> parentList;

    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null);
        }
    }

    public void add(int key) {
        int index;
        index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}

public class Problem1 {
    public static void main(String[] args) throws Exception {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1); // set = [1]
        myHashSet.add(2); // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2); // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2); // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
