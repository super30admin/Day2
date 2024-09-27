//Time Complexity: O(1);
//Space Complexity: O(1);
//
//Did it successfully run on Leetcode: Yes
//
//Any Problems : No


class MyHashSet {
    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i = 0;i<ARRAY_SIZE;i++){
            parentList.add(null);
        }


    }

    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList == null){
            List<Integer> list = new LinkedList();
            list.add(key);
            parentList.set(index,list);
        }
        else{
            if(!childList.contains(key)){
                childList.add(key);
            }
        }

    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList!=null && childList.contains(key);

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */