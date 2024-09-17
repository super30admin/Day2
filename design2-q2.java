class MyHashMap {
    class node{
        int key;
        int value;
        node next;
        
        public node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }
    node [] nodes;
    public MyHashMap() {
        nodes = new node[10000];
    }
    
    public int hash1(int key){
        return key%10000;
    }
    
    // We create a find function which can be reused in all other functions 
    private node find (node head, int target){
        node prev = head;
        node curr = head.next;
        while(curr!=null && curr.key!=target){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    // Overall Time complexity - O(1)
    public void put(int key, int value) {
        int index = hash1(key);
        if(nodes[index]==null){
            nodes[index]= new node(-1,-1);
        }
        node prev = find(nodes[index],key);
        if (prev.next==null){
            prev.next = new node(key,value);  
        }
        else
            prev.next.value = value;
    }
    // Overall Time complexity - O(1)
    public int get(int key) {
        int index = hash1(key);
        if(nodes[index]==null) return -1;
        node prev = find(nodes[index], key);
        if(prev.next==null) return -1;
        else return prev.next.value;
    }
    // Overall Time complexity - O(1)
    public void remove(int key) {
        int index = hash1(key);
        if(nodes[index]==null) return;
        node prev=find(nodes[index],key);
        if(prev.next==null) return;
        prev.next= prev.next.next;   
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */