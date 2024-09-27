

// Time Complexity : find -O(1), put-O(1), get-O(1) , remove-O(1)
// Space Complexity : O(10000+m) where m is no. of collision in first array  
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class MyHashMap {
    int primary;
    Node[] data;
    
    class Node{
        int val;
        int key;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private int hash(int key){
        return key % primary;
    }
    
    public MyHashMap() {
       this.primary = 10000;
        this.data = new Node[primary];
    }
    
    private Node find(Node node, int key){
        Node curr = node;
        Node prev = null;
       while (curr != null && curr.key != key){
           prev = curr;
           curr = curr.next;
       }
        return prev;
    }
    
    public void put(int key, int value) {
        int index= hash(key);
        if (data[index]==null){
            data[index]=new Node(-1,-1);
        }
        
        Node curr = find(data[index],key);
        if(curr.next == null){
            curr.next = new Node(key,value);
        }else{
            curr.next.val=value;
        }
    }
    
    public int get(int key) {
        int index= hash(key);
        if (data[index]==null){
            return -1;
        }
        Node curr = find(data[index],key);
        if(curr.next ==null){
            return -1;
        }else{
            return curr.next.val;
        }
    }
    
    public void remove(int key) {
        int index= hash(key);
        if (data[index]==null){
            return ;
        }
        Node curr = find(data[index],key);
        if(curr.next ==null){
            return ;
        }else{
           curr.next= curr.next.next;
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