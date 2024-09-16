package S30_Codes.Design_2;

// Time Complexity : O(n) // for all operation
// Space Complexity : O(n)
// Design - 2

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private static final int BUCKET_SIZE = 1_000;
    private Node[] arr;

    public MyHashMap() {
        arr = new Node[BUCKET_SIZE+1];
    }

    private int getHashCode(int key){
        return key/BUCKET_SIZE;
    }

    private Node getPrevious(int key){
        int hash = getHashCode(key);

        if(arr[hash] == null)
            return null;

        Node prev = arr[hash];
        Node current = prev.next;

        while(current != null && current.key != key){
            prev = current;
            current = current.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        Node prev = getPrevious(key);

        if(prev == null){
            int hash = getHashCode(key);
            arr[hash] = new Node(-1,-1);;

            Node newNode = new Node(key, value);
            arr[hash].next = newNode;
            return;
        }
        if(prev.next == null){
            Node newNode = new Node(key, value);
            prev.next = newNode;
            return;
        }
        else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        Node prev = getPrevious(key);
        if(prev == null || prev.next == null)
            return -1;

        return prev.next.value;
    }

    public void remove(int key) {
        Node prev = getPrevious(key);
        if(prev != null && prev.next != null){
            prev.next = prev.next.next;
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