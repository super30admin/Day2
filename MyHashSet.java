class MyHashSet {

    public static int Hash1_index = 1000;
    public static int Hash2_index = 1000;

    private boolean[][] arr;


    public MyHashSet() {
        arr = new boolean[Hash1_index][];
    }


    private int getHash1_index(int key) {
        return key % Hash1_index ;
    }

    private int getHash2_index(int key) {
        return key / Hash2_index ;
    }

    public void add(int key) {

        if (!this.contains(key)){
            int hash1 = getHash1_index(key);
            if (arr[hash1] == null) {
                // edge case of 10^6
                if (hash1 == 0){
                    arr[hash1] = new boolean[Hash1_index + 1];
                } else {
                    arr[hash1] = new boolean[Hash1_index];
                }

            }
            int hash2 = getHash2_index(key);
            arr[hash1][hash2] = true;
        }

    }

    public void remove(int key) {

        if(contains(key)){
            int hash1 = getHash1_index(key);
            int hash2 = getHash2_index(key);
            arr[hash1][hash2] = false;
        }

    }

    public boolean contains(int key) {

        int hash1 = getHash1_index(key);


        if(arr[hash1] == null){
            return false;
        }

        int hash2 = getHash2_index(key);

        return arr[hash1][hash2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no. it was solved in class
