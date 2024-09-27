//Time Complexity O(logn)
//Space Complexity O(1)
class MyHashSet {
    public boolean[][] storage;
    int bucketSize;
    int bucketValue;
    int bucketItems;

    public MyHashSet() {
        bucketSize = 1000;
        storage = new boolean[bucketSize][];
    }

    private int divideHashKey(int key) {
        return key / bucketSize;
    }

    private int delimiterHashKey(int key) {
        return key % bucketSize;
    }

    public void add(int key) {
        bucketValue = delimiterHashKey(key);
        bucketItems = divideHashKey(key);
        if (storage[bucketValue] == null) {
            if (bucketValue == 0) {
                storage[bucketValue] = new boolean[bucketSize + 1];
            } else {
                storage[bucketValue] = new boolean[bucketSize];
            }
        }
        storage[bucketValue][bucketItems] = true;
    }

    public void remove(int key) {
        bucketValue = delimiterHashKey(key);
        bucketItems = divideHashKey(key);
        if (storage[bucketValue] == null) {
            return;
        }
        storage[bucketValue][bucketItems] = false;

    }

    public boolean contains(int key) {
        bucketValue = delimiterHashKey(key);
        bucketItems = divideHashKey(key);
        if (storage[bucketValue] == null) {
            return false;
        }
        return storage[bucketValue][bucketItems];
    }

    public static void main(String[] args) {

        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1000000);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        boolean abc = myHashSet.contains(1); // return True
        boolean def = myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        boolean a = myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        boolean b = myHashSet.contains(2); // return False, (already removed)
    }
}

