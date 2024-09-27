class MyHashSet {
    class Store {
        int key;
        Store next;
        Store(int key) {
            this.key = key;
        }
    }
    Store[] myStore;
    /** Initialize your data structure here. */
    public MyHashSet() {
        myStore = new Store[10000];
    }
    
    public int getHashCode(int key) {
        return key % myStore.length;
    }
    
    public Store getPrevious(int index, int key) {
        Store s = myStore[index];
        if(s == null) {
            System.out.println("prevttt ");
            myStore[index] = new Store(-1);
            return myStore[index];
        }
        System.out.println("prevttt123 ");
        Store prev = s;
        while(prev.next!=null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
    
    public void add(int key) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        if(prev.next == null) {
            prev.next = new Store(key);
        } 
    }
    
    public void remove(int key) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        if(prev.next == null) {
            return false;
        }else {
            return true;
        }    
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */