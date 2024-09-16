class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] mainArray;
    int primIndex;
    int secIndex;

    public MyHashSet() {
        primIndex = 1000; //Set as 1000 since key max value is 10^6 and we will use the square root
        secIndex = 1000;
        mainArray = new boolean[primIndex][];
    }

    public int getPrimLoc(int key){
        return key%primIndex;
    }

    public int getSecLoc(int key){
        return key/secIndex;
    }
    public void add(int key) {
        int location1 = getPrimLoc(key);
        int location2 = getSecLoc(key);

        if(location1 == 0 && mainArray[location1]==null){
            mainArray[location1] = new boolean[1001];

        }
        if(mainArray[location1]==null){
            mainArray[location1] = new boolean[secIndex];

        }
        mainArray[location1][location2] = true;

    }

    public void remove(int key) {
        int location1 = getPrimLoc(key);
        int location2 = getSecLoc(key);

        if (mainArray[location1]!=null && mainArray[location1][location2] == true){
            mainArray[location1][location2] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int location1 = getPrimLoc(key);
        int location2 = getSecLoc(key);
        if(mainArray[location1]== null){
            return false;
        }
        return mainArray[location1][location2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */