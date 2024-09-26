import java.util.HashMap;
import java.util.Map;

class MyHashSet {
    Map<Integer, Boolean> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

    }

    public void add(int key) {
        if (!contains(key)) {
            map.put(key, true);
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            map.remove(key);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */