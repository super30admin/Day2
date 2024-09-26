// Time Complexity : O( number of all possible values/number of predefined buckets)
// Space Complexity : O(number of predefined buckets + unique values that have been inserted into the HashSet)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class MyHashSet {

    /** Initialize your data structure here. */
    int MAX = 1000000;
    int list_size = 10000;
    List<List<Integer>> parentlist ;


    public MyHashSet() {

        parentlist = new ArrayList<>(list_size);

        for(int i=0 ; i<list_size ; i++){
            parentlist.add(null);
        }

    }

    public void add(int key) {

        int index = key % list_size;
        List<Integer> childlist = parentlist.get(index);

        if(childlist == null){

            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentlist.set(index,list);
        }
        else{
            if(!childlist.contains(key)) childlist.add(key);
        }

    }

    public void remove(int key) {

        int index = key % list_size;
        List<Integer> childlist = parentlist.get(index);

        if(childlist != null){
            childlist.remove(Integer.valueOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % list_size;
        List<Integer> childlist = parentlist.get(index);

        return childlist!=null && childlist.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
