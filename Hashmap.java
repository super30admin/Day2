class Hashmap {
    class Node{
        int k;
        int v;
        Node next;
        
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    
    Node[] primaryArr;
    private int hashFunction(int k){
        return k%10000;
    }

    public HashMap(){
        this.primaryArr = new Node[10000];  
    }
    
    private Node findTarget(Node n, int k){
        Node prev = null;
        Node curr = n;
        while(curr != null && curr.k != k){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashValue = hashFunction(key);
        if(primaryArr[hashValue] == null){
            primaryArr[hashValue] = new Node(-1, -1);
        }
        Node prev = findTarget(primaryArr[hashValue], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.v = value;
        }
        
    }
    
    public int get(int key) {
        int hashValue = hashFunction(key);
        if(primaryArr[hashValue] == null){
            return -1;
        }
        Node prev = findTarget(primaryArr[hashValue], key);
        if (prev.next == null){
            return -1;
        }
        return prev.next.v;
        
    }
    
    public void remove(int key) {
        int hashValue = hashFunction(key);
        if(primaryArr[hashValue] == null){
            return;
        }
        Node prev = findTarget(primaryArr[hashValue], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
        
    }
    
}
