// Implement Hashmap

class MyHashMap {

    private int arr[][];
    private boolean initialized[][];
    public MyHashMap() {
        this.arr = new int[1000][];
        this.initialized = new boolean[1000][];
    }
    
    public void put(int key, int value) {
        int hash = key % 1000;
        int collisionHash = key/1000;
        if(arr[hash] == null) {
            if(hash == 0) {
                arr[hash] = new int[1001];
                initialized[hash] = new boolean[1001];
            }
            else {
                arr[hash] = new int[1000];
                initialized[hash] = new boolean[1000];
            }
                
        }
        arr[hash][collisionHash] = value;
        initialized[hash][collisionHash] = true;
    }
    
    public int get(int key) {
        int hash = key%1000;
        int collisionHash = key/1000;
        if(arr[hash] == null) return -1;
        if(initialized[hash][collisionHash] == false) return -1;
        return arr[hash][collisionHash];
    }
    
    public void remove(int key) {
        int hash = key%1000;
        int collisionHash = key/1000;
        if(arr[hash] != null) {
            arr[hash][collisionHash] = -1;
            initialized[hash][collisionHash] = false;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */