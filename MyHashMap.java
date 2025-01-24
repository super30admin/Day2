// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Used double hashing technique to store the key value pairs in the hashmap.

class MyHashMap {
    int buckets;
    int bucketSize;

    Node[][] map;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketSize = 1000;
        map = new Node[buckets][];
    }

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/buckets;
    }

    public void put(int key, int value) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(map[index1] == null){
            if(index1 == 0){
                map[index1] = new Node[bucketSize+1];
            }else{
                map[index1] = new Node[bucketSize];
            }
        }
        map[index1][index2] = new Node(key, value);
    }

    public int get(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(map[index1] == null || map[index1][index2] == null){
            return -1;
        }

        Node node = map[index1][index2];

        if(node.key == key){
            return node.val;
        }
        return -1;
    }

    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(map[index1] == null || map[index1][index2] == null){
            return;
        }
        Node node = map[index1][index2];
        node.key = -1;
    }
}

class Node {
    int val;
    int key;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */