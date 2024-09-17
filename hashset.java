// Time Complexity : O(1)
// Space Complexity : if n < 1000 O(1000) else O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
// hash key first time and insert/remove/check at first node else hash again and insert/remove/check all nodes.


class MyHashSet {

    /** Initialize your data structure here. */
    Node hashTable[];
    static final int hashKey = 1000;
    static final int hashKey2 = 997;
    public MyHashSet() {
        hashTable = new Node[1000];
    }
    
    public int hash(int key) {
        return key % hashKey;
    }
    public int hash2(int key) {
        return key % hashKey2;
    }
    
    public void add(int key) {
        int index = hash(key);
        
        if(hashTable[index] != null && hashTable[index].data != key){
            index = hash2(key);
        }
        //System.out.println(++i + " " + key + " " + index + " add");
        if(hashTable[index] == null){
            hashTable[index] = new Node(key);   
            return;
        }
        Node node = hashTable[index];
        if(node.data == key) return;
        while(node.next != null) {
            if(node.next.data == key) return;
            node = node.next;
        }
        node.next = new Node(key);        
    }
    
    public void remove(int key) {
        int index = hash(key);
        
        if(hashTable[index] != null && hashTable[index].data != key){
            index = hash2(key);
        }
        //System.out.println(++i + " " + key + " " + index+ " remove");
        if(hashTable[index] == null) return;
        Node node = hashTable[index];
        if(node.data == key){ hashTable[index] = node.next; return;}
        while(node.next != null) {
            if(node.next.data == key){
                Node next = node.next.next;
                node.next.next = null;
                node.next = next;
                return;
            }
            node = node.next;
        }        
    }
   
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       
        int index = hash(key);
        
        if(hashTable[index] != null && hashTable[index].data == key){
           return true;
        }
        index = hash2(key);
        //System.out.println(++i + " " + key + " " + index+ " cont");
        Node node = hashTable[index];
        while(node != null) {
            if(node.data == key) return true;
            node = node.next;
        }
        return false;
    }
    
    
    class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
        }
    }
}