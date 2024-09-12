public class MyHashSet
{

    boolean[][] storage;

    int bucket;

    int bucketItems;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet()
    {
        bucket = 1000;
        bucketItems = 1000;
        storage = new boolean[bucket][bucketItems];
    }

    public int bucket(int key)
    {
        return key % bucket;
    }

    public int bucketItem(int key)
    {
        return key / bucketItems;
    }

    public void add(int key)
    {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
        {
            if (bucket == 0)
            {
                storage[bucket] = new boolean[bucketItem + 1];
            }
            else
            {
                storage[bucket] = new boolean[bucketItem];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key)
    {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return;
        storage[bucket][bucketItem] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key)
    {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }

    public static void main(String[] arg)
    {
        MyHashSet obj = new MyHashSet();
        obj.add(34);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */