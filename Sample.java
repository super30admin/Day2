class MyHashSet {

    /**
     * Objective: Time complexity for accessing any element should be O(1)
     *
     * Problem space : Hashset should support 1 million elements
     *
     * Idea:
     *  Use a 2d matrix of size sqrt(1 million) * sqrt(1 million)
     *
     *  Invoke the 2nd dimension of the array only when an element comes up.
     *
     * boolean[1000][n]:
     *                  +-----+-----+-----+-----+-----+
     *       ----------> | [0] | [1] | [2] | [3] | [4] |...[1000]
     *                   +-----+-----+-----+-----+-----+
     *                      |     |     |     |     |
     *                      |     |     |     |     |
     *                      |     |     |     |     |
     *                      v     v     v     v     v
     *                   +-----+ ...   ...   ...   ...
     *                   |  true  |
     *                   +-----+
     *                   |  false  |
     *                     ...
     *
     * Hashing technique: Double hashing.
     *
     * In order to allocate a space or to find a number in the 2D array. The program will have to go through 2 levels
     *
     * 1. Level 1: Get bucket number
     *          bucketNumber = input % 1000
     *
     * 2. Level 2: Where the element actually resides
     *           bucketItemNumber = input / 1000
     *
     * Location of an element = array[bucketNumber][bucketItemNumber]
     *
     * Time complexity:
     *
     *  All the following operations involve calculating the exact location in the 2d array.
     *     * Add element : O(1)
     *     * Remove element: O(1)
     *     * contains element: O(1)
     *
     *Space complexity:
     *  No auxiliary space used. O(1)
     *  Overall max space is allocated for array[1000][1000]
     *  Is O(n)
     *
     */


    private int buckets;
    private int bucketItemNumber;
    private boolean storage [][];

    public MyHashSet() {


        buckets = 1000;
        bucketItemNumber = 1000;

        /**
         * Here we are only initialising level1 array.
         * storage is just a reference to 1D array of size 1000
         * https://stackoverflow.com/a/20938246
         */

        storage = new boolean[buckets][];

    }

    public void add(int key) {
        int bucketNumber = getBucketNumber(key);
        int bucketItem = getBucketItemNumber(key);

        // Check if 2D array is initialised at that bucketNumber
        // if not initialise
        if(storage[bucketNumber] == null) {
            if(bucketNumber == 0) {
                // in order to accommodate 1 million th number
                storage[bucketNumber] = new boolean[bucketItemNumber + 1];
            } else {
                storage[bucketNumber] = new boolean[bucketItemNumber];
            }
        }

        storage[bucketNumber][bucketItem] = true;
    }



    /*
        Calculate bucket location and bucketItem number, check if the element is present there
     */
    public void remove(int key) {
        int bucketNumber = getBucketNumber(key);
        if(storage[bucketNumber] == null)
            return;
        else {
            int bucketItem = getBucketItemNumber(key);
            storage[bucketNumber][bucketItem] = false;
        }
    }


    /*
        Calculate bucket location and bucketItem number, check if the element is present there
     */

    public boolean contains(int key) {
        int bucketNumber = getBucketNumber(key);
        if(storage[bucketNumber] == null)
            return false;
        else {
            int bucketItem = getBucketItemNumber(key);
            return storage[bucketNumber][bucketItem];
        }
    }

    private int getBucketNumber(int key) {
        return key % buckets;
    }

    private int getBucketItemNumber(int key) {
        return key / bucketItemNumber;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */