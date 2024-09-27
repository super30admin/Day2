/*******
## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

Time Complexity :   O (1) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (706. Design HashMap)
Any problem you faced while coding this :       No
*******/

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;

    public MyHashMap(){
        storage = new Node[10000];
    }

    private int getHash(int key){
        return key%10000;
    }

    private Node find(Node node, int key){
        Node prev = null;
        Node current = node;

        while(current != null && current.key != key){
            prev = current;
            current= current.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if(storage[hash]== null){
            storage[hash] = new Node(-1,-1);
        }
        Node prev = find(storage[hash], key);
        if (prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
        System.out.println("Added Key: " + prev.next.key);
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if(storage[hash]== null){
            System.out.println("Key is not present");
            return -1;
        }
        Node prev = find(storage[hash], key);
        if (prev.next == null){
            System.out.println("Key is not present");
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if(storage[hash]== null){
            System.out.println("Key is not present ! No value Removed from HashMap");
            return;
        }
        Node prev = find(storage[hash], key);
        if (prev.next == null){
            System.out.println("Key is not present ! No value Removed from HashMap");
            return;
        }
        else{
            System.out.println(prev.next + " Removed from HashMap");
            prev.next = prev.next.next;
        }
    }

    public static void main(String args[]) 
    { 
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        System.out.println("Key Found: "+ obj.get(1) + " from HashMap");
        obj.remove(1);
    }
}
