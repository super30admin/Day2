class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] map;

    public MyHashSet() {
        map = new boolean[1000][];
    }

    public void add(int key) {
        int primI = key % 1000;
        int secI = key / 1000;
        if(map[primI] == null) {
            if(primI == 0) {
                map[primI] = new boolean[1001];
            } else {
                map[primI] = new boolean[1000];
            }
        }
        map[primI][secI] = true;
    }

    public void remove(int key) {
        int primI = key % 1000;
        int secI = key / 1000;
        if(map[primI] != null && map[primI][secI] == true) {
            map[primI][secI] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int primI = key % 1000;
        int secI = key / 1000;
        if(map[primI] != null && map[primI][secI] == true) {
            return true;
        }
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