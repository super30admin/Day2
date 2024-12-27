// Time Complexity : Put, Get, Remove: O(n/maxSize)
// Space Complexity : O(bucketsize * length of LL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Tried implementing using array of linkedlists without using dummy node



public class MyHashMap {
    int maxSize = 10000;
    Node[] aoll ;

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }
    }

    public MyHashMap() {
        aoll= new Node[maxSize];
    }

    public int hash(int key){
        return key % maxSize;
    }

    public void put(int key, int value) {

        int index = hash(key);
        Node curr = aoll[index];

        if(curr == null){
            Node newNode = new Node(key,value);
            aoll[index] = newNode;
            return;
        }
        Node prev = null;
        while(curr != null){
            if(curr.getKey() == key){
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        Node newNode = new Node(key,value);
        prev.next = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = aoll[index];

        while(curr != null){
            if(curr.getKey() == key){
                return curr.getValue();
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = aoll[index];

        if(curr == null ){
            return;
        }

        Node prev = null;
        while(curr != null){
            if(curr.getKey() == key){
                if(prev == null){
                    aoll[index] = curr.next;
                }else{
                    prev.next = curr.next;

                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

