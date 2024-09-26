import javafx.scene.Node;

class MyHashMap {
    // Created class for node
    class Node {
        int key;
        int val;
        Node next;
        // Node will be having value key & next pointer
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node [] nodes;

    // initilizing nodes in hashmap
    MyHashMap() {
        nodes = new Node[10000];
    }

    // Hash function to return key index
    public int index(int key) {
        return key % 10000;
    }

    // find function to find node in linked list
    private Node find(Node head, int key) {
        // Having prev & curr pointer 
        Node prev = head;
        Node curr = head.next;
        // Current pointer is not null then assigning prev to current & current to next
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        // If current is null then prev pointer is our location so we return prev
        return prev;
    }

    public void put(int key, int value) {
        int index = index(key);
        // if head node is not there then we create head node with val -1 
        // to maintain the linkedlist structure
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        
        Node prev = find(nodes[index], key);
        // prev.next is null means it's last node so we will create new node with value
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            // prev.next is exist then override the value
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = index(key);
       // if head node is not there then return -1
        if (nodes[index] == null) {
            return -1;
        }
        Node prev = find(nodes[index], key);
        // if prev.next is null then we are at the end of the linkedlist and value is not present
        if (prev.next == null) {
            return -1;
        }
        // return prev.next's value as it's present in linked list
        return prev.next.val;
    }

    public void remove(int key) {
        int index = index(key);
        if (nodes[index] == null) {
            return;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            return;
        }
        // changing prev.next value to prev.next's next value means skipping node in between
        prev.next = prev.next.next;
    }
}

public class HashMap {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 2);
        int param_2 = obj.get(1);
        System.out.println("param_2: " + param_2);
        obj.remove(1);
    }
}
