// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took time to fully understand the find function.


// Your code here along with comments explaining your approach
/*
Implementing linear chaining technique by declaring an outer array of size 10^4 and inside
implemented a linked list of size 100.
 */

public class MyHashMap {
    static class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private final Node[] data;

    public MyHashMap() {
        this.data = new Node[1000];
    }

    private int hashFunctionForIndex(int key) {
        return key%1000;
    }

    private Node find(Node head, int key) {
        Node prev = null;
        Node current = head;
        while(current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hashFunctionForIndex(key);
        if(data[index] == null) {
            data[index] = new Node(-1,-1); //dummy node
        }
        Node prev = find(data[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        prev.next.val = value;
    }

    public int get(int key) {
        int index = hashFunctionForIndex(key);
        if(data[index] == null) return -1;
        Node prev = find(data[index], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int index = hashFunctionForIndex(key);
        if(data[index] == null) return;
        Node prev = find(data[index], key);
        if(prev.next == null) return;
        Node tempNode = prev.next;
        prev.next = prev.next.next;
        tempNode = null;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1,1);
        myHashMap.put(2,2);
        int get1 = myHashMap.get(1);
        int get2 = myHashMap.get(3);
        myHashMap.put(2,1);
        int get3 = myHashMap.get(2);
        myHashMap.remove(2);
        int get4 = myHashMap.get(2);
        System.out.println(get1 + " " + get2 + " " + get3 + " " + get4);
    }
}