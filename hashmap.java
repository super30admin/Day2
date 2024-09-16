class MyHashMap {

    static class ListNode {
        int key, val;
        ListNode next;
        
        ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    ListNode[] map;

    public MyHashMap() {
        map = new ListNode[10000];
    }
    
    ListNode find(ListNode x, int key) {
        if (x == null) 
            return null;
        if (x.key == key) 
            return x;
        
        return find(x.next, key);
    }
    
    ListNode remove(ListNode x, int key) {
        if (x == null) 
            return null;
        if (x.key == key) 
            return x.next;
        x.next = remove(x.next, key);
        return x;
    }
    
    public void put(int key, int value) {
        int hash = key % 10000;
        ListNode x = find(map[hash], key);
        if (x != null) {
            x.val = value;
        } else {
            map[hash] = new ListNode(key, value, map[hash]);
        }
    }
    
    public int get(int key) {
        int hash = key % 10000;
        ListNode x = find(map[hash], key);
        if (x != null) return x.val;
        return -1;
    }

    public void remove(int key) {
        int hash = key % 10000;
        map[hash] = remove(map[hash], key);
    }    

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */