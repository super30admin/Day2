class Hashset {

    // Time Complexity : o(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    boolean[][] Hash;
    int PrimaryArray;
    int SecondaryArray;

    public HashSet() {
        PrimaryArray = 1000;
        SecondaryArray = 1000;
        Hash = new boolean[PrimaryArray][];
    }

    public int findPrimaryArrayIndex(int key) {
        return key % PrimaryArray;
    }

    public int findSecondaryArrayIndex(int key) {
        return (key / SecondaryArray);
    }

    public void add(int key) {
        int OuterArray = findPrimaryArrayIndex(key);
        int InnerArray = findSecondaryArrayIndex(key);
        if (Hash[OuterArray] == null) {

            if (OuterArray == 0) {
                Hash[OuterArray] = new boolean[SecondaryArray + 1];

            } else {
                Hash[OuterArray] = new boolean[SecondaryArray];

            }

        }

        Hash[OuterArray][InnerArray] = true;

    }

    public void remove(int key) {
        int primaryArrayIndex = findPrimaryArrayIndex(key);
        int secondaryArrayIndex = findSecondaryArrayIndex(key);

        if (Hash[primaryArrayIndex] == null) {
            return;
        }

        Hash[primaryArrayIndex][secondaryArrayIndex] = false;

    }

    public boolean contains(int key) {
        int primaryArrayIndex = findPrimaryArrayIndex(key);
        int secondaryArrayIndex = findSecondaryArrayIndex(key);

        if (Hash[primaryArrayIndex] == null) {
            return false;
        } else {
            return Hash[primaryArrayIndex][secondaryArrayIndex];
        }

    }


/*
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
