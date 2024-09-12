//Time complexity is O(1) as array lookup is O(1)
//Space complexity is O(N) where N is 1000006
class MyHashMap {
    int size = (int)Math.pow(10, 6)+1;
    int[] hm = new int[size];
    public MyHashMap() {
        Arrays.fill(hm, -1);
    }
    
    public void put(int key, int value) {
        hm[key] = value;
    }
    
    public int get(int key) {
        return hm[key];
    }
    
    public void remove(int key) {
        hm[key]=-1;
    }
}


//Approach learn from class
//Time complexity is O(1)
//Space complexity is O(N)
//Able to submit in leetcode
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public  Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    int count;
    private int oneHashing(int key){
        return key%count;
    }

    private Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
    }
    public MyHashMap() {
        nodes = new Node[1000];
        count =1000;
    }
    
    public void put(int key, int value) {
        int hash = oneHashing(key);
        if(nodes[hash]==null){
            nodes[hash]= new Node(-1, -1);
        }
        Node prev = find(nodes[hash], key);
        if(prev.next!=null){
            prev.next.value=value;
            return;
        }
        prev.next=new Node(key, value);
    }
    
    public int get(int key) {
        int hash = oneHashing(key);
        if(nodes[hash]==null)
        return -1;
        
        Node prev = find(nodes[hash], key);
        if(prev.next!=null)
            return prev.next.value;
        return -1;
    }
    
    public void remove(int key) {
        int hash = oneHashing(key);
        if(nodes[hash]==null)
        return;
        Node prev= find(nodes[hash], key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }
}

