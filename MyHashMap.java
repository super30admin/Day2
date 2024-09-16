import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private static final int SIZE = 809; //prime number
    private static final int NOT_FOUND = -1;
    private final Bucket[] buckets;

    public MyHashMap() {
        buckets = new Bucket[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            buckets[i] = new Bucket<Integer, Integer>();
        }
    }

    public void put(int key, int value) {
        buckets[hashKey(key)].insertIntoBucket(key, value);
    }

    public int get(int key) {
        return buckets[hashKey(key)].getValue(key) != null ? (int) buckets[hashKey(key)].getValue(key) : NOT_FOUND;
    }

    public void remove(int key) {
        buckets[hashKey(key)].removeFromBucket(key);
    }

    private int hashKey(int key) {
        return key % SIZE;
    }
}

class Bucket<K, V> {

    private final LinkedList<Pair<K, V>> bucketPairs;

    public Bucket() {
        bucketPairs = new LinkedList<>();
    }

    protected void insertIntoBucket(K key, V value) {
        Pair<K, V> pair = findPair(key);
        if (pair != null) {
            pair.value = value;
            return;
        }
        bucketPairs.addFirst(new Pair(key, value));

    }

    protected void removeFromBucket(K key) {
        Pair<K, V> pair = findPair(key);
        if (pair != null) {
            bucketPairs.remove(pair);
        }
    }

    protected V getValue(K key) {
        Pair<K, V> pair = findPair(key);
        return pair != null ? pair.value : null;
    }

    private Pair<K, V> findPair(K key) {
        Iterator<Pair<K, V>> it = bucketPairs.iterator();
        while (it.hasNext()) {
            Pair<K, V> pair = it.next();
            if (pair.key.equals(key)) {
                return pair;
            }
        }
        return null;
    }
}

class Pair<K, V> {

    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
