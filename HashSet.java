//TC : The time complexity for add, remove, contains is O(1),
// SC : The space complexity is O(n) for this approach.
class HashSet {
    boolean set[][];
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public HashSet() {
        set = new boolean[1000][];
        buckets = 1000;
        bucketItems = 1000;
    }

    //Find both the indices for the primary as well as for the secondary array and update the value accordingly.
    //if there is a null value at the primary index then we assign it new memoery of 1000 elements
    public void add(int key) {
        int index1 = key%1000;
        if(set[index1] == null)
            set[index1] = new boolean[1000];
        int index2 = key/1000;
        set[index1][index2] = true;
    }

    //find the indices and set value as false if found
    public void remove(int key) {
        int index1 = key%1000;
        int index2 = key/1000;

        if(set[index1] == null) return;

        set[index1][index2]=false;
    }

    /** Returns true if this set contains the specified element */
    //find the indices and retrun the value stored
    public boolean contains(int key) {
        int index1 = key%1000;
        int index2 = key/1000;

        if(set[index1] == null) return false;

        return set[index1][index2];
    }

    public static void main(String args[]) {

        HashSet myHashSet = new HashSet();
        myHashSet.add(5);
        myHashSet.add(12);
        myHashSet.add(100);
        myHashSet.add(1002);
        System.out.println("12 present :"+myHashSet.contains(12)); // true
        myHashSet.remove(12);
        System.out.println("12 present :"+myHashSet.contains(12)); //false
    }
}

/**
output:

12 present :true
12 present :false
 */ 