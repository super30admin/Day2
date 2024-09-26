// Time Complexity : O(1) for add, remove and contains.
// Space Complexity : O(N) where N is size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    boolean[][] set;
    int bucketSize;
    int bucketLstSize;

    public MyHashSet() {
        bucketSize = 1000;
        bucketLstSize = 1000;
        set = new boolean[bucketSize][];
    }
    
    public void add(int key) {
        int idx1 = key % bucketSize;
        int idx2 = key / bucketSize;

        if(set[idx1] == null){
            if(idx1 == 0){
                set[idx1] = new boolean[bucketLstSize + 1];
            }else{
                set[idx1] = new boolean[bucketLstSize];
            }
        }
        set[idx1][idx2] = true;
    }
    
    public void remove(int key) {
        int idx1 = key % bucketSize;
        int idx2 = key / bucketSize;

        if(set[idx1] == null){
            return;
        }else{
            set[idx1][idx2] = false;
        }
    }
    
    public boolean contains(int key) {
        int idx1 = key % bucketSize;
        int idx2 = key / bucketSize;

        if(set[idx1] == null){
            return false;
        }else{
            return set[idx1][idx2];
        }
    }
}

class HashSet{

    public static void main(String args[]){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(3));
        System.out.println(hashSet.contains(1));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }
}
