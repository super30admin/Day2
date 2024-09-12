//Overall Time Complexity: O(N/K) -> N:Total keys, K:# of elements in bucket
//Overall Space Complexity: O(M + N) -> N:# of unique keys, M:# of elements in bucket
class Node{
    int key;
    int val;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    Node[] data;

    public MyHashMap() {
        data = new Node[10000];
    }

    //Time Complexity: O(N/K) -> N:Total keys, K:# of elements in bucket
    public void put(int key, int val) {
        int hashVal = hash(key);
        Node newNode = new Node(key, val);

        if(data[hashVal] == null){
            data[hashVal] = new Node(-1,-1);
        }

        Node node = getLoc(data[hashVal], key);

        if(node.next == null) node.next = newNode;
        else node.next.val = val;

    }

    //Time Complexity: O(N/K) -> N:Total keys, K:# of elements in bucket
    public int get(int key) {
        int hashVal = hash(key);
        Node node = getLoc(data[hashVal], key);
        if(node==null || node.next == null) return -1;
        else return node.next.val;
    }

    //Time Complexity: O(N/K) -> N:Total keys, K:# of elements in bucket
    public void remove(int key) {
        int hashVal = hash(key);
        Node node = getLoc(data[hashVal], key);

        // Nothing in that key location
        if(node == null){
            return;
        }
        else if(node.next != null){
            node.next = node.next.next;
        }
        return;
    }

    private Node getLoc(Node node, int key){
        Node prev = null;
        Node curr = node;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    private int hash(int key){
        return key % 10000;
    }
}
