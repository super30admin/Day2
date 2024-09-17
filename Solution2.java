//Design HashSet
//S:O(1)
//T:O(1)
class MyHashSet {


    boolean[][] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new boolean[1000][];
    }

    public int hashfuncSet(int key){
        return key%1000;
    }

    public int hashfuncSetVal(int key){
        return key/1000;
    }

    public void add(int key) {
        int M = hashfuncSet(key);
        int N = hashfuncSetVal(key);

        if(set[M]==null){
            set[M] = new boolean[1000];
        }

        set[M][N] = true;
    }

    public void remove(int key) {
        int M = hashfuncSet(key);
        int N = hashfuncSetVal(key);

        if(set[M]!=null)
            set[M][N]=false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int M = hashfuncSet(key);
        int N = hashfuncSetVal(key);

        if(set[M]!=null)
            if(set[M][N])
                return true;

        return false;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */