// Time Complexity : O(1000) => O(1)
// Space Complexity : O(1000000)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Here I have designed HashMap using hashing and linear approach. I have designed a 10000 continuous slots and
each slot would have 1000 slots of linked list, which is non-continous. Using first layer of hashing, it would
return the hashing position. After getting the particular index, we would implement linked list.
 */


class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] hashmap;
    public MyHashMap() {
        this.hashmap = new Node[10000];
    }

    public int hash1Key(int key){
        return key%10000;
    }

    public Node traverse(Node node, int key){
        Node prev = null;
        Node curr = node;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }


    public void put(int key, int value) {
        int hash1 = this.hash1Key(key);
        if(hashmap[hash1]==null){
            hashmap[hash1] = new Node(-1, -1);
        }
        Node prev = this.traverse(hashmap[hash1], key);
        if(prev.next==null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hash1 = this.hash1Key(key);
        if(hashmap[hash1]==null) return -1;
        Node prev = this.traverse(hashmap[hash1], key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int hash1 = this.hash1Key(key);
        if(hashmap[hash1]==null) return;
        Node prev = this.traverse(hashmap[hash1], key);
        if(prev.next==null){
            return;
        }
        else{
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