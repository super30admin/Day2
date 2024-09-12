// Time Complexity : average O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MyHashMap {
    class Node{
        int data;
        int val;
        Node next;

        public Node(int d, int val){
            this.data = d;
            this.val = val;
        }
    }

    Node[] array;

    public MyHashMap() {
        this.array = new Node[10000];
    }

    private int hash(int key){
        return key%10000;
    }

    private Node find(Node node, int key){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.data != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if(array[index] == null){
            array[index] = new Node(-1, -1);
        }
        Node prev = find(array[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if(array[index] == null) return -1;
        Node prev = find(array[index], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int index = hash(key);
        if(array[index] == null) return;
        Node prev = find(array[index], key);
        if(prev.next == null){
            return;
        } else {
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