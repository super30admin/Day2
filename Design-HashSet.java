class MyHashSet {

    /** Initialize your data structure here. */
    // Time O(1)
    // Space O(1)
    boolean Hashset[][];
    int len1 = 1000 , len2 = 1000;
    public MyHashSet() {
        Hashset = new boolean[len1][];
    }
    
    public void add(int key) {
        int index1 = key % len1;
        int index2 = key / len2;
        if(Hashset[index1] == null)
        {
            Hashset[index1] = new boolean[len2];
        }
        Hashset[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = key % len1;
        int index2 = key / len2;
        if(Hashset[index1] != null)
        {
            Hashset[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = key % len1;
        int index2 = key / len2;
        if(Hashset[index1] == null)
        {
            return false;
        }
        return Hashset[index1][index2];
    }
    public static void main(String args[])
    {
        MyHashSet hs = new MyHashSet();
        hs.add(1);hs.add(2);hs.add(1);
        System.out.println("contains 1 : "+ hs.contains(1));
        hs.remove(1);
        System.out.println("contains 1 : "+ hs.contains(1));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */