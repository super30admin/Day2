// Time Complexity O(N/MAX) - N: number of elements , MAX : numbers of containers
// Space Complexity O(MAX + U) - U: Unique elements mapped to a hashed index.

class MyHashSet {
    private int MAX = 999;
    private Container [] containers;
    
    public MyHashSet() {
        containers = new Container[MAX];
        
        for(int i = 0; i < MAX; i++) {
            this.containers[i] = new Container();
        }
    }
    
    private int getHash(int key) {
        return key % this.MAX;
    }
    
    public void add(int key) {
        int idx = getHash(key);
        Container con = this.containers[idx];
        con.add(key);
    }
    
    public void remove(int key) {
         int idx = getHash(key);
         Container con = this.containers[idx];
         con.remove(key);
    }
    
    public boolean contains(int key) {
        int idx = getHash(key);
        Container con = containers[idx];
        return con.contains(key);
    }
}

class Container {
    LinkedList<Integer> container;
    
    public Container() {
        this.container = new LinkedList<Integer>();
    }
    
    public void add(int key) {
        if(!this.contains(key)) {
            this.container.add(key);
        }
    }
    
    public void remove(Integer key) {
        this.container.remove(key);
    }
    
    public boolean contains(Integer key) {
        return -1 != this.container.indexOf(key);
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
