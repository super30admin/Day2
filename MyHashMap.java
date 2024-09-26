class MyHashMap {
    private Node [] arr;
    private static final int BUCKET_SIZE =10000;

    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int value){
            key = key;
            val = value;
        }
    }

    private int hashfn(int key){
        return key/100;
    }

    public MyHashMap() {
        arr = new Node[BUCKET_SIZE];
    }

    public void put(int key, int value) {
        Node prev = getPrev(key);
        //key absent and bucket absent
        if(prev == null){
            int hash = hashfn(key);   //initialize bucket itself
            arr[hash] = new Node(-1,-1); // dummy node
            prev = arr[hash];
        }

        //key is absent - tail node
        if(prev.next== null)
            prev.next = new Node(key,value);
        else   //key is already present, so update value
            prev.next.val = value;

    }

    //returns tail node if not present
    public Node getPrev(int key){
        int hash = hashfn(key);

        if(arr[hash] ==null )
            return null;

        Node prev = arr[hash];
        Node curr = prev.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public int get(int key) {
        Node prev = getPrev(key);

        if(prev ==null || prev.next ==null)
            return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        Node prev = getPrev(key);

        if(prev != null && prev.next!=null)
            prev.next = prev.next.next;

    }

    public static void main(String [] args){

    }
}