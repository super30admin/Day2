class Node {
    int key;
    int val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
    }
}

class MyHashMap {

    Node[] node;

    public MyHashMap() {
        node = new Node[1000];
    }
    
    public int getBucket(int key) {
        return key % 1000;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);

        if(node[bucket] == null) {
            Node newNode = new Node(key, value);
            node[bucket] = newNode;
        } else {
            Node curr = node[bucket];
            Node prev = curr;
            boolean found = false;

            while(curr != null) {
                if(curr.key == key) {
                    curr.val = value;
                    found = true;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }

            if(!found) {
                Node newNode = new Node(key, value);
                prev.next = newNode;
            }
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(node[bucket] == null) {
            return -1;
        } else {
            Node curr = node[bucket];
            while(curr != null) {
                if(curr.key == key) {
                    return curr.val;
                }
                curr = curr.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);

        if(node[bucket] != null) {
            Node curr = node[bucket];
            Node prev = curr;

            if(curr.key == key && curr == prev) {
                node[bucket] = curr.next;
                return;
            }

            while(curr != null) {
                if(curr.key == key) {
                    prev.next = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
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
