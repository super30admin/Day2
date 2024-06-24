// Time Complexity: 0(1)
// space-complexity:0(1) not considering the array space created for hashmap

class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node( int key, int value){
            this.key = key;
            this.value = value;
        }
    } 
    private Node[] storage;
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    public Node find(int idx,int key){
        Node prev=null;
        Node current = storage[idx]; 
        while(current!=null && current.key!=key){
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public int idx(int key){
        return key%10000;
    }
    public void put(int key, int value) {
        int idx = idx(key);
        if(storage[idx]==null){
            storage[idx] = new Node(-1,-1);
        } 
        Node previous = find(idx,key);
              if(previous.next == null){
                Node current = new Node(key, value);
                previous.next = current;
                current.next=null;
             } else{
                Node current = previous.next;
                current.value = value;
             }
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(storage[idx]==null) return -1;
        else{
            Node previous = find(idx,key);
            if(previous==null) return -1;
            else if(previous.next==null) return -1;
            else  {
               return previous.next.value;
            }
        }
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if(storage[idx]==null) return;
        else{
            Node previous = find(idx,key);
             if(previous==null) return;
            else if(previous.next==null) return;
            else {
                Node temp = previous.next;
                previous.next = previous.next.next;
                temp.next = null;
            }
        }
    }

    public static void main(String args[]){
         MyHashMap obj = new MyHashMap();
         obj.put(1,2);
         int param_2 = obj.get(1);
         obj.remove(1);
        System.out.println(param_2);
    }
  }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */