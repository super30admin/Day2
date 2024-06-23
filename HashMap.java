/*
Method: put(int key, int value)
TC: O(N / SIZE) on average
SC: O(N)
Method: get(int key)
TC: O(N / SIZE) on average
SC: O(1)
Method: remove(int key)
TC: O(N / SIZE) on average
SC: O(1)
*/


import java.util.LinkedList;

class MyHashMap {


    private final int SIZE = 1001;
    private LinkedList<Entry>[] hashTable;

    private static class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public MyHashMap() {
        hashTable = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int index = linearHash(key);
        if(hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        LinkedList<Entry> bucket = hashTable[index];
        for(Entry entry: bucket) {
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key,value));

    }

    public int get(int key) {
        int index = linearHash(key);
        if(hashTable[index] == null)
            return -1;
        LinkedList<Entry> bucket = hashTable[index];
        for(Entry entry: bucket) {
            if(entry.key == key)
                return entry.value;
        }
        return -1;

    }

    public void remove(int key) {
        int index = linearHash(key);
        if(hashTable[index] == null)
            return;
        LinkedList<Entry> bucket = hashTable[index];
        Iterator<Entry> iterator = bucket.iterator();
        while(iterator.hasNext()) {
            Entry entry = iterator.next();
            if(entry.key == key) {
                iterator.remove();
                return;
            }
        }

    }

    private int linearHash(int key) {
        return key % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

