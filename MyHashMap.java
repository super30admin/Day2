public class MyHashMap {

    // Node class to represent a key-value pair in a linked list
        class Node {
            int key;
            int val;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Node[] map;             //Primary array

        public MyHashMap() {
            this.map = new Node[10000];
        }

        // Hash function to calculate the index for a given key
        private int hash(int key){
            return key%100;
        }

        // Helper function to search for a node. It returns the previous node
        private Node search(Node head, int key){
            Node prev = head;
            Node cur = head.next;

            while(cur != null && cur.key != key){
                prev = cur;
                cur = cur.next;
            }

            return prev;

        }

        // Insert a key-value pair or update the value if the key already exists
        public void put(int key, int value) {
            int index = hash(key);
            // If the bucket at the index is empty, initialize it
            if(map[index] == null){
                map[index] = new Node(-1,-1);
            }

            Node prev = search(map[index], key);

            if(prev.next == null){
                prev.next = new Node(key, value);
            }else {
                prev.next.val = value;
            }
        }

        public int get(int key) {
            int index = hash(key);

            if(map[index] == null){return -1;}

            Node prev = search(map[index], key);

            if(prev.next != null){
                return prev.next.val;
            }else{
                return -1;
            }
        }

        public void remove(int key) {
            int index = hash(key);

            if(map[index] == null) return;

            Node prev = search(map[index], key);

            if(prev.next == null){
                return;
            }else{
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

//TimeComplexity: put -> Amortized O(1)
//remove -> Amortized O(1)
//get -> Amortized O(1)
// Space Complexity : Space for buckets-> O(n)
//Auxiliary space -> O(1)


