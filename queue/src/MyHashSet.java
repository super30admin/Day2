class MyHashSet {
    private int bucket=1000;
    private int bucketItem=1000;

    private int hashfunc1(int key){
        return key%bucket;
    }

    private int hashfunc2(int key){
        return key/bucketItem;
    }

    private boolean[][] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[bucket][];

    }

    public void add(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);

        if(hashSet[index1]==null){
            hashSet[index1]= new boolean[bucketItem];
        }
        hashSet[index1][index2]= true;

    }

    public void remove(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        if(hashSet[index1] != null){
            hashSet[index1][index2]= false;
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        if(hashSet[index1] != null){
            return hashSet[index1][index2];
        }
        return false;
    }

}