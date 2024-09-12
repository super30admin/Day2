// constant time complexity for all operations

class MyHashMap {

    // to store key and value pair
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[][] hash;
    private int count;
    private int max;
    private int hashkey;

    public MyHashMap() {
        this.hash = new Node[1000+1][];
        this.count = 0;
        this.max = 1000000;
        this.hashkey = (int) Math.pow(this.max, 0.5);
    }

    // we find the first hash value with modulus and the second with division
    public void put(int key, int value) {
        int hashvalue = key % this.hashkey;
        if (this.hash[hashvalue] == null) {
            this.hash[hashvalue] = new Node[this.hashkey+1];
        }
        int secondhash = key / this.hashkey;
        this.hash[hashvalue][secondhash] = new Node(key, value);
        this.count++;
        return;
    }

    // return the value by first applying mod and then division
    public int get(int key) {
        int firsthash = key%this.hashkey;
        if(this.hash[firsthash] == null){
            return -1;
        }
        int secondhash = key/this.hashkey;
        if(this.hash[firsthash][secondhash] == null){
            return -1;
        }
        return this.hash[firsthash][secondhash].value;
    }

    // find the value and make it null
    public void remove(int key) {
        int firsthash = key%this.hashkey;
        int secondhash = key/this.hashkey;
        if(this.hash[firsthash] == null){
            return;
        }
        this.hash[firsthash][secondhash] = null;
        return;
    }
}