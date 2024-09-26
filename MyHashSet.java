//Time Complexity : O(1) for all functions

import java.util.*;

class MyHashSet {
    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;

    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null); // making each bucket null initially
        }
    }

    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList == null) { // if there is no element present at that index then we will create a new
                                 // linkedlist and add our key value there
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            if (!childList.contains(key)) { // if element is present then we will simply append to the linkedlist
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
