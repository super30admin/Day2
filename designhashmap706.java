
// Time Complexity : Put/Remove/Get - O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Used a combinaton of array and linkedlist to avoid collision and reduce space.
class MyHashMap {

    Node[] buckets;
        public MyHashMap() {
           buckets = new Node[1000]; 
        }
        
        public void put(int key, int value) {
            
            Node prev = getNode(key);
            if(prev.next == null){
                prev.next = new Node(key, value);
                return;
            }
            prev.next.value = value;
        }
        
        public int get(int key) {
            Node prev = getNode(key);
            if(prev.next == null){
                return -1;
            }
            return prev.next.value;
        }
        
        public void remove(int key) {
            Node prev = getNode(key);
            if(prev.next == null){
                return;
            }
            prev.next = prev.next.next;
        }
        public Node getNode(int key){
            int bucket = getBucket(key);
            Node head = buckets[bucket];
            if(head == null){
                buckets[bucket] = new Node(-1,-1);
                return buckets[bucket];
            }
            while(head.next != null && head.next.key != key){
                head = head.next;
            }
            return head;
        }
        public int getBucket(int key){
            return key % 1000;
        }
    }
    class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */