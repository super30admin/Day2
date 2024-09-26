

class HashMap {
    int primaryBuckets;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }


    public HashMap() {
        this.primaryBuckets = 1000;
        this.storage = new Node[primaryBuckets];
    }

    private int getPrimaryHash(int key){
        return key%primaryBuckets;
    }

    public void put(int key, int value) {
        int index = getPrimaryHash(key);
        if(storage[index] == null){
            //System.out.println("for key" + key + "initializing");
            storage[index] = new Node(-1,-1);
            Node first = new Node(key,value);
            storage[index].next = first;
            return;
        }
        else{
            Node cur = storage[index];
            while(cur.key!=key && cur.next!=null){
                cur = cur.next;
            }
            if(cur.key == key){
                cur.value = value;
                return;
            }
            else{
                Node first = new Node(key,value);
                cur.next = first;
                return;
            }

        }
    }

    public int get(int key) {
        int index = getPrimaryHash(key);
        if(storage[index] == null){
            //System.out.println("get" + key + "here in storage null");
            return -1;
        }
        else{
            Node cur = storage[index];
            while(cur.key != key && cur.next != null){
                cur = cur.next;
            }
            if(cur.key == key) {
                return cur.value;
                }
            else{
                return -1;
                }
        }

    }

    public void remove(int key) {
        int index = getPrimaryHash(key);
        if(storage[index] == null)
        {
            return;
        }
        else{
            Node cur = storage[index];
            Node prev = cur;;
            while(cur.key != key && cur.next != null){
                prev = cur;
                cur = cur.next;
            }
            if(cur.key == key){
                prev.next = cur.next;
                cur.next = null;
            }
            else {
                return;
            }
        }


    }
}