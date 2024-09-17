//  Time Complexity O(1) for ADD, REMOVE, CONTAINS. Space complexity O(1)

// Approach 
// The add operations first does the modulo and finds the index of array to store it.
// The Contains function looks for the index first and then into list if found returns true.
// The remove operation uses the lookup into index and then finds in the list once found removes it from the list. 

class MyHashSet {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private int size;
    private Node[] array;

    public MyHashSet() {
        this.size = 100;
        this.array = new Node[100];
    }

    public void add(int key) {
        int index = key % this.size;
        if(this.array[index] == null) {
            this.array[index] = new Node(key);
            return;
        } else {
            Node p = this.array[index];
            while(p != null && p.val != key) 
                p = p.next;

            if(p != null) 
                return;

            Node newHead = new Node(key);
            newHead.next = this.array[index];
            this.array[index] = newHead;
        }
    }

    public void remove(int key) {
        int index = key % this.size;
        if(this.array[index] == null) {
            return;
        } else {
            Node p = this.array[index];

            if(p.val == key) {
                this.array[index] = p.next;
                return;
            }

            while(p.next != null && p.next.val != key)
                p = p.next;
            if(p.next == null)
                return;

            p.next = p.next.next;
        }
    }

    public boolean contains(int key) {
        int index = key % this.size;
        if(this.array[index] == null)
            return false;
        Node p = this.array[index];
        while(p != null && p.val != key)
            p = p.next;
        return p != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */