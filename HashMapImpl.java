/**
 * Time complexity of all the operations on an average is O(1)
 * Space complexity is O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class HashMapImpl {


    class Node{
        int key, value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int buckets;
    Node[] nodes;

    public HashMapImpl() {
        this.buckets = 10000;
        nodes = new Node[buckets];
    }

    private Node find(Node head,int key){
        Node previous = head;
        Node current = head.next;
        while(current != null && current.key != key){
            previous = current;
            current = current.next;
        }
        return previous;
    }

    private int hash(int key){
        //return Integer.hashcode(key) % buckets;
        return key % buckets;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }

        Node prev = find(nodes[index], key);

        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);

        if(nodes[index] == null){
            return -1;
        }

        Node prev = find(nodes[index], key);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if(nodes[index] == null){
            return;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        HashMapImpl obj = new HashMapImpl();
        obj.put(10,20);
        System.out.println(obj.get(10));;
        obj.remove(10);
    }
}
