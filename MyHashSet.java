class MyHashSet {
    int[] arr;
    public MyHashSet() {
        arr = new int[1000001];
    }
    
    public void add(int key) {
        arr[key] = 10;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
    
    public boolean contains(int key) {
        return arr[key] == 10;
    }
}
