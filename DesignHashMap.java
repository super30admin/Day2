// Time Complexity: 0(1)
// space-complexity:0(1)
//Approach: Using a hashmap with linear chaining is a way to handle hash collisions.
public class DesignHashMap {

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] storage;
    private int bucket;

    public DesignHashMap(){
        this.bucket=1000;
        this.storage = new Node[bucket];
    }

    private int hash(int key){
        return key%bucket;
    }

    private Node search(int key){
        int index = hash(key);
        Node previous = null;
        Node current = storage[index];
        while(current!=null && current.key!=key){
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public void put(int key, int value){
        int index = hash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1, -1);
        }
        Node previous = search(key);
        if(previous.next == null){
            previous.next = new Node(key, value);
        }
        else{
            previous.next.value=value;
        }

    }

    public int get(int key){
        int index = hash(key);
        if(storage[index] == null){
            return -1;
        }
        Node previous = search(key);
        if(previous.next == null){
            return -1;
        }
        else{
            return previous.next.value;
        }
    }

    private void remove(int key){
        int index = hash(key);
        if(storage[index] == null){
            return;
        }
        Node previous = search(key);
        if(previous.next == null){
            return ;
        }
        else{
            Node current = previous.next;
            previous.next = previous.next.next;
            current.next = null;
        }
    }

    public static void main(String[] args) {
        DesignHashMap designHashMap = new DesignHashMap();
        designHashMap.put(20,25);
        designHashMap.put(40,60);
        designHashMap.remove(40);
        System.out.println("Get key 40 is:" + designHashMap.get(40));
    }
}
