//TC : The time complexity for add, remove, contains is O(1),
// SC : The space complexity is O(n) for this approach.
class MyHashSet {
    boolean matrix[][];
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        matrix = new boolean[1000][];
        buckets = 1000;
        bucketItems = 1000;
    }

    //here we find both the indices for the primary as well as for the secondary array and update the value accordingly.
    //if there is a null value at the primary index then we assign it new memoery of 1000 elements
    public void add(int key) {
        int index = key%1000;
        if(matrix[index] == null)
            matrix[index] = new boolean[1000];
        int secondary_index = key/1000;
        matrix[index][secondary_index] = true;
    }

    //find the indices and set value as false if found
    public void remove(int key) {
        int index = key%1000;
        int secondary_index = key/1000;

        if(matrix[index] == null) return;

        matrix[index][secondary_index]=false;
    }

    /** Returns true if this set contains the specified element */
    //find the indices and retrun the value stored
    public boolean contains(int key) {
        int index = key%1000;
        int secondary_index = key/1000;

        if(matrix[index] == null) return false;

        return matrix[index][secondary_index];
    }

    public static void main(String args[]) {


        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(5);
        myHashSet.add(12);
        myHashSet.add(1005);
        System.out.println("The element 5 is present or not? "+myHashSet.contains(5)); // true
        myHashSet.remove(5);
        System.out.println("The element 5 is present or not? "+myHashSet.contains(5)); //false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */